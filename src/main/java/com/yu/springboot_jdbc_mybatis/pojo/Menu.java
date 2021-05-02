package com.yu.springboot_jdbc_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//无参构造
@AllArgsConstructor//有参构造
public class Menu {
    private int menuid;
    private String menutitle;
    private String menudate;
    private int menured;
    private int menucomment;
    private  int titleid;
    private String info1;
    private String info2;
    private int rightto;
    private String detailstext;
}
