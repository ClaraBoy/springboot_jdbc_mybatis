package com.yu.springboot_jdbc_mybatis.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;

@Data
@NoArgsConstructor//无参构造
@AllArgsConstructor//有参构造
public class Users implements Serializable, AuthCachePrincipal {
    private int uid;
    private String uname;
    private  String upwd;
    private  String uemile;
    private String upower;
    private  String nickname;
    private String applicationid;

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", uemile='" + uemile + '\'' +
                ", upower='" + upower + '\'' +
                ", nickname='" + nickname + '\'' +
                ", applicationid='" + applicationid + '\'' +
                '}';
    }

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}
