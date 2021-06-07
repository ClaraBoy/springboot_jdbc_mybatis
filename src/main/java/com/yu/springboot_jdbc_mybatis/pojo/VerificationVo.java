package com.yu.springboot_jdbc_mybatis.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerificationVo {
    private String uname;
    private  String upwd;
    private  String uemile;
    private String verificationCode;
}
