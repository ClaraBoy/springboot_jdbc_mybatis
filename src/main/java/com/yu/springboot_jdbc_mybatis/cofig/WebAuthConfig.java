package com.yu.springboot_jdbc_mybatis.cofig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import javax.annotation.Resource;
/**
 * @author Clara
 */
@Configuration
public class WebAuthConfig extends WebMvcConfigurationSupport {
    @Resource
    private TokenInterceptor tokenInterceptor;
    public WebAuthConfig(TokenInterceptor tokenInterceptor){
        this.tokenInterceptor = tokenInterceptor;
    }
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/addComment");
    }
}
