package com.yu.springboot_jdbc_mybatis.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    private int id;
    private String songurl;
    private int ofNumber;
}
