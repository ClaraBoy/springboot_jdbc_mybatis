package com.yu.springboot_jdbc_mybatis.tool;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/**
 * @author 二十九
 */
@Aspect
@Component
public class Annaop {
    //使用了拦截器代替了代理 最终没有使用
   // @Around("execution(* com.yu.springboot_jdbc_mybatis.controller.ClaraController.Queryuser(..))") 相当于在那些请求上使用代理
    public void before(){
        System.out.println("注解前");
    }

    public void after(){
        System.out.println("注解后");
    }
}
