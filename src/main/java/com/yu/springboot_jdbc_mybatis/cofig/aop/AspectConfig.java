package com.yu.springboot_jdbc_mybatis.cofig.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect //切面类
public class AspectConfig {
    @Around("@annotation(com.yu.springboot_jdbc_mybatis.tool.Annotation)") //自定义注解  包含自定义注解的注解才生效
    public Object AroundAfter(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { //运行中的连接点
        System.out.println("------------------进入环绕------------------");
            //System.out.println(proceedingJoinPoint.getTarget());
            //System.out.println(proceedingJoinPoint.getSignature().getName());
        System.out.println("-------------------环绕前------------------");
        Object proceed=  proceedingJoinPoint.proceed();
        System.out.println("-------------------环绕后------------------");

        System.out.println("-------------------退出环绕------------------");
        return proceed;
    }
}
