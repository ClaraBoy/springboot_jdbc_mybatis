package com.yu.springboot_jdbc_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminLoginVo {
    private int id;
    private String name;
    private String pwd;
    private String imageUrl;
    private String upower;
    private String lastTime;
    private String token;

}
