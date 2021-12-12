package com.yu.springboot_jdbc_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 二十九
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopiccommentsVo {
    private int id;
    private String topicname;
    private String topictitle;
    private String topictext;
    private String topicdate;
    private int topicred;
    private  String applicationid;
    int number;
}
