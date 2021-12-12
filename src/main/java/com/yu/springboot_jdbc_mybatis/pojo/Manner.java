package com.yu.springboot_jdbc_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 二十九
 * 点赞表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manner {
    private int id;
    private String mannerName;
    private String mannerTitle;
    private String mannerapplicationid;
    private String manner;
}
