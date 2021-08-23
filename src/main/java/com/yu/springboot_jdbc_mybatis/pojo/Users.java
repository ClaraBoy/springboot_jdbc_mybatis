package com.yu.springboot_jdbc_mybatis.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor//无参构造
@AllArgsConstructor//有参构造
public class Users {
    private int uid;
    private String uname;
    private  String upwd;
    private  String uemile;
    private String upower;
    private  String nickname;
}
