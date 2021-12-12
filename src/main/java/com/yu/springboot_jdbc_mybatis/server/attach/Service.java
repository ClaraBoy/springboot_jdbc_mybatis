package com.yu.springboot_jdbc_mybatis.server.attach;

import com.yu.springboot_jdbc_mybatis.pojo.ApplicationUser;
import com.yu.springboot_jdbc_mybatis.pojo.Menu;

import java.util.List;

/**
 * @author 二十九
 * 附加功能
 */
public interface Service{
    List<ApplicationUser> queryall();
    int queryAppUser(String applicationid);
    int addAppUser(ApplicationUser user);
    int updatePower(String upower,String uname);
    int updatePass(String remark1,String applicationid);
    List<Menu> queryMenuNo(String Review);
    Menu queryMenuOnle(String menuid);
    int passMenu(String menuid);
    int deleteAppUser(String applicationid);
    List<Menu> queryMenu(String applicationid,int start,int end);
    int total(String applicationid);
    int deleteAppMenu(int menuid);
    int updateAppMenu(Menu menu);
}
