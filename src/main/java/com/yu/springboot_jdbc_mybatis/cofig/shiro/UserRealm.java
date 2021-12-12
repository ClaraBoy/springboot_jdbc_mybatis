package com.yu.springboot_jdbc_mybatis.cofig.shiro;
import com.yu.springboot_jdbc_mybatis.pojo.Users;
import com.yu.springboot_jdbc_mybatis.server.original.ServicesImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 二十九
 */
public class UserRealm extends AuthorizingRealm {
    //规则名
    @Override
    public String getName() {
        return "UserRealm";
    }
    private ServicesImpl servicesImpl;
    @Autowired
    public void setServices(ServicesImpl servicesImpl) {
        this.servicesImpl = servicesImpl;
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户的对象
        Users users= (Users) principalCollection.getPrimaryPrincipal();
        //一般使用user对象强转即可
        //授予权限
        SimpleAuthorizationInfo info= new SimpleAuthorizationInfo();
        //权限来自数据库
        info.addStringPermission(users.getUpower());
        info.addRole("admin");
        return info;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名和密码 数据库
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;
        System.out.println("user规则");
        //比较用户
        Users users = servicesImpl.Queryuser(usernamePasswordToken.getUsername());
        //密码认证 shiro替你做
        if(users!=null){
            return new SimpleAuthenticationInfo(users,users.getUpwd(),"UserRealm");
        }
        return null;
    }

    /**
     * 自定义方法：清除所有 授权缓存
     */
    public void clearAllCachedAuthorizationInfo(String uname) {
        System.out.println(getAuthorizationCache().size());
        Cache<Object, AuthorizationInfo> cache=getAuthorizationCache();
        for (Object key : cache.keys()) {
            System.out.println(cache.get(key));
        }
       // getAuthorizationCache().remove(uname);
    }

    /**
     * 自定义方法：清除所有 认证缓存
     */
    public void clearAllCachedAuthenticationInfo(String uname) {
        System.out.println(getAuthorizationCache());
       // getAuthenticationCache().remove(uname);
    }

    /**
     * 自定义方法：清除所有的  认证缓存  和 授权缓存
     */
    public void clearAllCache(String uname) {
        clearAllCachedAuthenticationInfo(uname);
        clearAllCachedAuthorizationInfo(uname);
    }

    @Override
    protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }
}
