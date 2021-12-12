package com.yu.springboot_jdbc_mybatis.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author 二十九
 * 收藏表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class LuckUser {
    private int id;
    private int sing;
    private String nickname;
}
