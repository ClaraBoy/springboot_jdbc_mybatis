package com.yu.springboot_jdbc_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor//无参构造
@AllArgsConstructor//有参构造
public class Topiccomments {
    private int id;
    private String topicname;
    private String topictitle;
    private String topictext;
    private String topicdate;
    private int topicred;
    private  String applicationid;
    private List<RepleComments> repleComments;


    @Override
    public String toString() {
        return "Topiccomments{" +
                "id=" + id +
                ", topicname='" + topicname + '\'' +
                ", topictitle='" + topictitle + '\'' +
                ", topictext='" + topictext + '\'' +
                ", topicdate='" + topicdate + '\'' +
                ", topicred=" + topicred +
                ", repleComments=" + repleComments +
                ", applicationid='" + applicationid + '\'' +
                '}';
    }
}
