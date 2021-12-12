package com.yu.springboot_jdbc_mybatis.mappers;
import com.yu.springboot_jdbc_mybatis.pojo.ApplicationUser;
import com.yu.springboot_jdbc_mybatis.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 标识这是一个MapperDao接口主要实现和mapper.xml的联系
 * */
@Mapper
/**
 * @author 二十九
 * 附加功能
 */
public interface ApplicationMapper {
    //查询所有提交
    List<ApplicationUser> queryall();
    //是否提交
    int queryAppUser(String applicationid);
    //申请成为创作者
    int addAppUser(ApplicationUser user);
    //修改用户的权限
    int updatePower(String upower,String uname);
    //申请通过
    int updatePass(String remark1,String applicationid);
    //申请失败
    //查询所有审核文章
    List<Menu> queryMenuNo(String Review);




    //查询单个文章
    Menu queryMenuOnle(String menuid);
    //通过文章
    int passMenu(String menuid);
    //通知用户未通过文章mq
    //删除申请者
    int deleteAppUser(String applicationid);
    //查询自己的文章
    List<Menu> queryMenu(String applicationid,int start,int end);
    //查询总条数
    int total(String applicationid);
    //删除文章
    int deleteAppMenu(int menuid);
    //修改文章
    int updateAppMenu(Menu menu);

}
