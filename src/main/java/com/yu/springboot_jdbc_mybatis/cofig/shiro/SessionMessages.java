package com.yu.springboot_jdbc_mybatis.cofig.shiro;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @author 二十九
 * 自定义sessmessage
 */
@Component
public class SessionMessages extends DefaultWebSessionManager {
    /**
     * 指定获取id方式
     *
     **/
    public SessionMessages() {
        super();
    }
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        //获取请求头数据Authorization
        String id= WebUtils.toHttp(request).getHeader("Authorization");
        if(StringUtils.isEmpty(id)){
            //第一次使用生成一个
            return super.getSessionId(request,response);
        }else{
            //获取id
            //id来源
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "header");
            //值是什么
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
            //是否需要验证
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            //返回sessionid
            return id;
        }
    }
}
