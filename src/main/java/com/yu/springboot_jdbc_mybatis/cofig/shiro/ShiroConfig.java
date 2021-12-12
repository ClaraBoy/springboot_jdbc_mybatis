package com.yu.springboot_jdbc_mybatis.cofig.shiro;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 * @author 二十九
 * 权限配置文件
 */
@Configuration
public class ShiroConfig {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;
    //规则
    @Bean
    public UserRealm getUserRealm(){
        //userRealm规则对象
        return new UserRealm();
    }
    @Bean
    public AdminRealm getAdminRealm(){
        //adminRealm规则对象
        return new AdminRealm();
    }
    //下面就是认证器的配置
    @Bean
    public CustomModularRealmAuthenticator authenticator(){
        CustomModularRealmAuthenticator authenticator = new CustomModularRealmAuthenticator();
        return authenticator;
    }
    //安全管理器
    @Bean
    public DefaultWebSecurityManager  getSecurityManager(UserRealm userRealm,AdminRealm adminRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        DefaultSubjectDAO subjectDAO=new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator=new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);
        //规则集合
        securityManager.setAuthenticator(authenticator());
        List<Realm> realms = new ArrayList<>();
        realms.add(userRealm);
        realms.add(adminRealm);
        //把自定义管理器注册到安全管理器里'
        //多规则
        securityManager.setRealms(realms);
        //单规则
        // securityManager.setRealm(userRealm);
        securityManager.setSessionManager(defaultWebSessionManagers());
        //自定义redis放入
          securityManager.setCacheManager(cacheManager());
        //关联userRealm规则对象
        return securityManager;
    }
    @Bean
    public ShiroFilterFactoryBean shirFilter(DefaultWebSecurityManager securityManager) {
        //配置shiro过滤器工厂
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //注意过滤器配置顺序 不能颠倒
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了，登出后跳转配置的loginUrl
        //登录请求
        shiroFilterFactoryBean.setLoginUrl("/err");
        shiroFilterFactoryBean.setUnauthorizedUrl("/No_authorization");
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        filterChainDefinitionMap.put("/member","perms[会员]");
        // 登录成功后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权界面;
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
    //1.redis控制器 操作redis
    public RedisManager redisManager(){
        RedisManager redisManager=new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
//        redisManager.setTimeout(timeout);
        redisManager.setDatabase(3);
        return redisManager;
    }
    //2.sessiondao
    public RedisSessionDAO redisSessionDAO(){
        RedisSessionDAO sessionDAO=new RedisSessionDAO();
        sessionDAO.setRedisManager(redisManager());
        sessionDAO.setExpire(90*60);
        return sessionDAO;
    }
    //3.会话管理管理器
    public DefaultWebSessionManager defaultWebSessionManagers(){
        SessionMessages sessionMessages =new SessionMessages();
        sessionMessages.setSessionDAO(redisSessionDAO());
        sessionMessages.setGlobalSessionTimeout(90*60*1000);
        return sessionMessages;
    }
    //4.缓存管理器
        public RedisCacheManager cacheManager(){
        RedisCacheManager redisCacheManager=new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
        }
    /***
     * 授权所用配置
     *
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }
}
