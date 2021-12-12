package com.yu.springboot_jdbc_mybatis.cofig.Interceptor;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yu.springboot_jdbc_mybatis.pojo.Users;
import com.yu.springboot_jdbc_mybatis.server.original.ServicesImpl;
import com.yu.springboot_jdbc_mybatis.tool.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
//拦截器（登陆拦截）
class TokenInterceptor implements HandlerInterceptor {
    private ServicesImpl servicesImpl;

    @Autowired//把服务层注册到web
    public void setServices(ServicesImpl servicesImpl) {
        this.servicesImpl = servicesImpl;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        String token = request.getHeader("authorization");
        String refreshAuthorization = request.getHeader("refresh_authorization");
        if (token != null) {
            DecodedJWT decodedJWT = Token.verify(token);
            if (decodedJWT != null) {
                Users user = servicesImpl.Queryuser(Token.getUserId(decodedJWT));
                if (!Token.isUpdatedPassword(decodedJWT, user)) {
                    //如果需要重新创建一个token 则通知客户端保存新的toekn 并且将新的token返回
                    if (Token.needCreate(decodedJWT)) {
                        JSONObject tokenJson = new JSONObject();
                       // tokenJson.put("token", Token.sign(user.getNickname(), Token.getTime(),user.getUpwd()));
                        tokenJson.put("success", "false");
                        tokenJson.put("msg", "认证失败，未通过拦截器");
                        tokenJson.put("code", "500");
                        response.setCharacterEncoding("UTF-8");
                        response.setContentType("application/json; charset=utf-8");
                        response.getWriter().append(tokenJson.toJSONString());
                        return false;
                    } else {
                        return true;
                    }
                }
            }else{
                if(refreshAuthorization!=null) {
                    DecodedJWT decodedJWT2 = Token.verify(refreshAuthorization);
                    if (decodedJWT2 != null) {
                        Users user = servicesImpl.Queryuser(Token.getUserId(decodedJWT2));
                        JSONObject tokenJsonTo = new JSONObject();
                        tokenJsonTo.put("token", Token.sign(user.getNickname(), Token.getTime(), user.getUpwd()));
                        tokenJsonTo.put("success", "true");
                        tokenJsonTo.put("msg", "认证通过");
                        tokenJsonTo.put("code", "201");
                        response.getWriter().append(tokenJsonTo.toJSONString());
                        return false;
                    }
                }
            }
        }
        try {
            JSONObject json = new JSONObject();
            json.put("success", "false");
            json.put("msg", "认证失败，未通过拦截器");
            json.put("code", "500");
            response.getWriter().append(json.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;
    }
}