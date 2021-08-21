package com.yu.springboot_jdbc_mybatis.tool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Clara
 * 自定义注解 自定义类有且只能有一个入口方法 方法名必须是bugs
 */
@Retention(RetentionPolicy.RUNTIME) //运行时
@Target(ElementType.METHOD)//注解作用于方法
public @interface Annotation {
}
