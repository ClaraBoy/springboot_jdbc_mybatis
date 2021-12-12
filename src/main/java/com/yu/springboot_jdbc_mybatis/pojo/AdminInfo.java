package com.yu.springboot_jdbc_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInfo {
    private int id;
    private String adminName;
    private String adminpwd;
    private String imageUrl;
    private String upower;
    private String lastTime;

    @Override
    public String toString() {
        return "AdminInfo{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", adminpwd='" + adminpwd + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", upower='" + upower + '\'' +
                ", lastTime='" + lastTime + '\'' +
                '}';
    }
}
