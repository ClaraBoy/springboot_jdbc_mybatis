package com.yu.springboot_jdbc_mybatis.tool;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class Annaop {
   // @Around("execution(* com.yu.springboot_jdbc_mybatis.controller.ClaraController.Queryuser(..))")
    public void before(){
        System.out.println("注解前");
    }

    public void after(){
        System.out.println("注解后");
    }
}
