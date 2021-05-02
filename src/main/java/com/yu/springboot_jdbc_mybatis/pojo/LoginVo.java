package com.yu.springboot_jdbc_mybatis.pojo;
import lombok.Data;
@Data
public class LoginVo {
    /**
     * 操作码（1:注册  0：登录）
     */
    private Integer option;

    private Integer uid;
    /**
     * 用户名
     */
    private String userName;
    /**
     * tokens
     */
    private String token;

    /**
     * 登录时间
     */
    private String loginTime;
    /**
     * 昵称
     * */
    private String nickname;

    public LoginVo(Integer option, Integer uid, String userName,String token, String loginTime, String nickname) {
        this.option = option;
        this.uid = uid;
        this.userName = userName;
        this.token = token;
        this.loginTime = loginTime;
        this.nickname=nickname;
    }
    public LoginVo() {
    }
}
