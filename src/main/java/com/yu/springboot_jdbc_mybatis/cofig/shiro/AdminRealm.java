package com.yu.springboot_jdbc_mybatis.cofig.shiro;

import com.yu.springboot_jdbc_mybatis.pojo.AdminInfo;
import com.yu.springboot_jdbc_mybatis.server.original.ServicesImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminRealm extends AuthorizingRealm {
    //规则名
    @Override
    public String getName() {
        return "AdminRealm";
    }
    private ServicesImpl servicesImpl;
    @Autowired
    public void setServices(ServicesImpl servicesImpl) {
        this.servicesImpl = servicesImpl;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名和密码 数据库
        System.out.println("admin规则");
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;
        AdminInfo adminInfo= servicesImpl.adminLogin(usernamePasswordToken.getUsername());
            if(adminInfo!=null){
                return new SimpleAuthenticationInfo("",adminInfo.getAdminpwd(),"AdminRealm");
            }
                return null;
    }
}
