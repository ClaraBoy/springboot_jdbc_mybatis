package com.yu.springboot_jdbc_mybatis.mappers;
import com.yu.springboot_jdbc_mybatis.pojo.RepleComments;
import com.yu.springboot_jdbc_mybatis.pojo.User;
import com.yu.springboot_jdbc_mybatis.pojo.Topiccomments;
import com.yu.springboot_jdbc_mybatis.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

//相当于dao层
@Mapper//标识这是一个MapperDao接口主要实现和mapper.xml的联系
@Repository//被spring整合在这里可有可无
//前台接口
public interface ClaraMapper {//一个接口
    User Queryuser(String uname);//用户登陆
    List<User> Querynickname();//用户昵称
    List<Menu> QueryAllMenuComments(int comments);//一个查询评论选项卡的方法
    List<Menu> QueryAllMenuYear(String year);//一个查询年选项卡的方法
    int QueryAllMenuCount();//内容条数
    List<Menu> QueryLists(int RigHtTo);//普通全部内容
    List<Menu> queryMenuList();//全部内容
    Menu QueryByDetails(String menutitle);//通过标题查询内容
    List<Topiccomments> QueryComment(String topictitle);//查询所有评论
    int addComment(Topiccomments topiccomments);//添加评论
    List<RepleComments>QueryRepleComments(String repletitle);//根查询
    int ReplyComment(RepleComments repleComments);//回复评论
//后台
    int AddMenu(Menu menu);//添加menu
    int deleteMenu(int id);//删除menu
    int deleteDetails(int id);//删除内容
    int deleteMenuAll(List<Integer> list);//批量删除
}