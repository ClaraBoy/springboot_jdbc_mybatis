package com.yu.springboot_jdbc_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 二十九
 * 关注表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Focus {
    private int id;
    private String focusName;
    private String focusapplicationid;

    @Override
    public String toString() {
        return "Focus{" +
                "id=" + id +
                ", focusName='" + focusName + '\'' +
                ", focusapplicationid='" + focusapplicationid + '\'' +
                '}';
    }
}
