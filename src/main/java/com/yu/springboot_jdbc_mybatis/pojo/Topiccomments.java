package com.yu.springboot_jdbc_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//无参构造
@AllArgsConstructor//有参构造
public class Topiccomments {
    private int id;
    private String topicid;
    private String topictitle;
    private String topictext;
    private String topicdate;
    private String topicred;
}
