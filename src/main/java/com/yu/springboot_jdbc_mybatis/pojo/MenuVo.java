package com.yu.springboot_jdbc_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//无参构造
@AllArgsConstructor//有参构造
public class MenuVo {
    private int menuid;
    private String menutitle;
    private String menudate;
    private int menured;
    private int menucomment;
    private  int titleid;
    private String info1;
    private String info1Url;
    private String info2;
    private String info2Url;
    private int rightto;
    private String detailstext;
    private String applicationid;
    private String Review;
    private int likeNum;
    private byte[] MenuImage;

    @Override
    public String toString() {
        return "MenuVo{" +
                "menuid=" + menuid +
                ", menutitle='" + menutitle + '\'' +
                ", menudate='" + menudate + '\'' +
                ", menured=" + menured +
                ", menucomment=" + menucomment +
                ", titleid=" + titleid +
                ", info1='" + info1 + '\'' +
                ", info1Url='" + info1Url + '\'' +
                ", info2='" + info2 + '\'' +
                ", info2Url='" + info2Url + '\'' +
                ", rightto=" + rightto +
                ", detailstext='" + detailstext + '\'' +
                ", applicationid='" + applicationid + '\'' +
                ", Review='" + Review + '\'' +
                ", likeNum=" + likeNum +
                ", MenuImage='" + MenuImage + '\'' +
                '}';
    }
}

