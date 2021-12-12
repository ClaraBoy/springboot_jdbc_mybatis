package com.yu.springboot_jdbc_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 二十九
 *附加类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUser {
    private int id;
    private String applicationid;
    private String applicationrealityName;
    private String applicationcardID;
    private String applicationNickName;
    private String applicationimageUrl;
    private String applicationdate;
    private String remark1;
    private String remark2;
}
