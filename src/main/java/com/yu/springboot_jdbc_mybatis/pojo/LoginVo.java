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


    private String refreshToken;

    /**
     * 登录时间
     */
    private String loginTime;
    /**
     * 昵称
     * */
    private String nickname;
/**
 * sessionid
 * */
    private String sessionId;

    private String applicationid;

    public LoginVo(Integer option, Integer uid, String userName, String token,String refreshToken, String loginTime, String nickname, String sessionId,String applicationid) {
        this.option = option;
        this.uid = uid;
        this.userName = userName;
        this.token = token;
        this.refreshToken=refreshToken;
        this.loginTime = loginTime;
        this.nickname = nickname;
        this.sessionId = sessionId;
        this.applicationid=applicationid;
    }

    public LoginVo() {
    }
}
