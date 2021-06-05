package com.yu.springboot_jdbc_mybatis.server;
import com.yu.springboot_jdbc_mybatis.pojo.RepleComments;
import com.yu.springboot_jdbc_mybatis.pojo.Topiccomments;
import com.yu.springboot_jdbc_mybatis.pojo.User;
import com.yu.springboot_jdbc_mybatis.pojo.Menu;

import java.util.LinkedList;
import java.util.List;

//服务接口层
public interface Services_in {
    //前台
    User Queryuser(String uname);//用户登陆
    List<User> Querynickname();//用户昵称
    int addUser(User user);//用户注册
    String QueryuserOnly(String uname,String uemile,String nickname);//查询单个用户
    List<Menu> QueryAllMenuComments(int comments);//一个查询评论选项卡的方法
    List<Menu> QueryAllMenuYear(String year);//一个查询年选项卡的方法
    int QueryAllMenuCount();//内容条数
    List<Menu> QueryLists(int RigHtTo);//普通全部内容
    List<Menu> queryMenuList();//全部内容
    Menu QueryByDetails(String menutitle);//通过标题查询内容
    String QueryById(int menuid);//通过id查标题单个
    List<String> QueryByIdall(List<Integer> menuid);//通过id查标题多行
    List<Topiccomments> QueryComment(String topictitle);//查询所有评论
    int addComment(Topiccomments topiccomments);//添加评论
    int QueryTopiccommentscomment(String menutitle);//查询Topiccomments的评论数方法1
    int UpdateMenutitle(int menucomment,String menutitle);//修改menu评论数条数方法2
    void UpadteMenured(String menutitle);//访问量
    List<RepleComments>QueryRepleComments(String repletitle);//根查询
    int ReplyComment(RepleComments repleComments);//回复评论





    //后台
    int AddMenu(Menu menu);//添加menu
    int deleteMenu(int id);//删除menu
    int deleteDetails(int id);//删除内容
    void deletetopiccomments(String menutitle);//删除评论单个
    void deletetopiccommentsall(List<String> menutitle);//删除评论多行
    int deleteMenuAll(List<Integer> list);//批量删除
}
