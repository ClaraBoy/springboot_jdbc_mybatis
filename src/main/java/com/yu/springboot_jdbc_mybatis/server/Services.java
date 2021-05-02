package com.yu.springboot_jdbc_mybatis.server;
import com.yu.springboot_jdbc_mybatis.mappers.ClaraMapper;
import com.yu.springboot_jdbc_mybatis.pojo.RepleComments;
import com.yu.springboot_jdbc_mybatis.pojo.Topiccomments;
import com.yu.springboot_jdbc_mybatis.pojo.User;
import com.yu.springboot_jdbc_mybatis.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Services implements Services_in {
    @Autowired
    ClaraMapper claramapper;
    @Override
    public User Queryuser(String uname) {
        return claramapper.Queryuser(uname);
    }
    @Override
    public List<User> Querynickname() {
        return claramapper.Querynickname();
    }
    @Override
    public List<Menu> QueryAllMenuComments(int comments) {
        return claramapper.QueryAllMenuComments(comments);
    }
    @Override
    public List<Menu> QueryAllMenuYear(String year) {
        return claramapper.QueryAllMenuYear(year);
    }
    @Override
    public int QueryAllMenuCount() {
        return claramapper.QueryAllMenuCount();
    }
    @Override
    public List<Menu> QueryLists(int RigHtTo){
        return claramapper.QueryLists(RigHtTo);
    }
    @Override
    public List<Menu> queryMenuList() {
        return claramapper.queryMenuList();
    }
    @Override
    public Menu QueryByDetails(String menutitle) {
        return claramapper.QueryByDetails(menutitle);
    }
    @Override
    public List<Topiccomments> QueryComment(String topictitle) {
        return claramapper.QueryComment(topictitle);
    }
    @Override
    public int addComment(Topiccomments topiccomments) {
        return claramapper.addComment(topiccomments);
    }

    @Override
    public List<RepleComments> QueryRepleComments(String repletitle) {
        return claramapper.QueryRepleComments(repletitle);
    }
    @Override
    public int ReplyComment(RepleComments repleComments) {
        return claramapper.ReplyComment(repleComments);
    }
    //后台
    @Override
    public int deleteMenu(int id) {
        return claramapper.deleteMenu(id);
    }
    @Override
    public int deleteDetails(int id) {
        return claramapper.deleteDetails(id);
    }
    @Override
    public int deleteMenuAll(List<Integer> list) {
        return claramapper.deleteMenuAll(list);
    }
    @Override
    public int AddMenu(Menu menu) {
        return claramapper.AddMenu(menu);
    }

}
