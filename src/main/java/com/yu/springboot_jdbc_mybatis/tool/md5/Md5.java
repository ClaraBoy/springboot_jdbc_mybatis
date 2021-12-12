package com.yu.springboot_jdbc_mybatis.tool.md5;
import org.springframework.util.DigestUtils;
/**
 * @author 二十九
 */
public class Md5 {
    /**
     * 盐，用于混交md5
     * */
    private static String salt = "Asd12_qS";
    /**
     *加密
     * */
public static Object encryption(String pwd){
    return pwd;
}
    /**
     *验证
     * */
public static Boolean decrypt(String pwd,String pwd2){
    String base = pwd + salt;
    return DigestUtils.md5DigestAsHex(base.getBytes()).equals(pwd2);
}
}
