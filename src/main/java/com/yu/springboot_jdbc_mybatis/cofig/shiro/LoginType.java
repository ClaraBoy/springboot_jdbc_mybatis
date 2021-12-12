package com.yu.springboot_jdbc_mybatis.cofig.shiro;

public enum LoginType {
    USER("UserRealm"), ADMIN("AdminRealm");
        //定义的是登陆的类型
        private String type;

    private LoginType(String type){
        this.type=type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}
