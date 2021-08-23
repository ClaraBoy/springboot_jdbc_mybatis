package com.yu.springboot_jdbc_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notify {
    private  int  notify_id;
    private  String   content;
    private String   type;
    private String   target_name;
    private String   action;
    private String   sender_name;
    private int      is_read;
    private  String  created_at;
}
