package com.yu.springboot_jdbc_mybatis.cofig;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yu.springboot_jdbc_mybatis.pojo.Users;
import com.yu.springboot_jdbc_mybatis.server.Services;
import com.yu.springboot_jdbc_mybatis.tool.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
//拦截器（登陆拦截）
class TokenInterceptor implements HandlerInterceptor {
    private Services services;

    @Autowired//把服务层注册到web
    public void setServices(Services services) {
        this.services = services;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("authorization");
        if (token != null) {
            DecodedJWT decodedJWT = Token.verify(token);
            if (decodedJWT != null) {
                Users user = services.Queryuser(Token.getUserId(decodedJWT));
                if (!Token.isUpdatedPassword(decodedJWT, user)) {
                    //如果需要重新创建一个token 则通知客户端保存新的toekn 并且将新的token返回
                    if (Token.needCreate(decodedJWT)) {
                        JSONObject tokenJson = new JSONObject();
                        tokenJson.put("token", Token.sign(user.getNickname(), Token.getTime(),user.getUpwd()));
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
            }
        }
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                JSONObject json = new JSONObject();
                json.put("success", "false");
                json.put("msg", "认证失败，未通过拦截器");
                json.put("code", "500");
                response.getWriter().append(json.toJSONString());
                System.out.println("认证失败，未通过拦截器");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(500);
                return false;
            }
            return false;
        }
    }