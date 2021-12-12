package com.yu.springboot_jdbc_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 二十九
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Search_history {
   private int id;
   private String userName;
   private String searchhistry;

   @Override
   public String toString() {
      return "Search_history{" +
              "id=" + id +
              ", userName=" + userName +
              ", searchhistry=" + searchhistry +
              '}';
   }
}
