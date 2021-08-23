package com.yu.springboot_jdbc_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepleComments {
    private int id;
    private String commentname;
    private String replename;
    private int repleType;
    private String repletitle;
    private String repletext;
    private int fromusid;
    private int touid;
    private String repledate;
}
