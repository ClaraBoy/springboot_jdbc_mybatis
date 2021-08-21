package com.yu.springboot_jdbc_mybatis.server;
import com.yu.springboot_jdbc_mybatis.mappers.ClaraMapper;
import com.yu.springboot_jdbc_mybatis.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public  class  Services implements Services_in {
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
    public int addUser(User user) {
        return claramapper.addUser(user);
    }

    @Override
    public int UpdateUserPwd(VerificationVo verificationVo) {
        return claramapper.UpdateUserPwd(verificationVo);
    }

    @Override
    public String QueryemileByNickname(String nickname) {
        return claramapper.QueryemileByNickname(nickname);
    }

    @Override
    public int addLuckUser(String nickname, int sing) {
        return claramapper.addLuckUser(nickname,sing);
    }

    @Override
    public Song QuerySongUrl() {
        return claramapper.QuerySongUrl();
    }

    @Override
    public int UpdateSongNumber() {
        return claramapper.UpdateSongNumber();
    }

    @Override
    public void DeleteLuckUser() {
        claramapper.DeleteLuckUser();
    }

    @Override
    public void DeletSongUrl() {
        claramapper.DeletSongUrl();
    }

    @Override
    public LuckUser QueryLuckUser(String nickname) {
        return claramapper.QueryLuckUser(nickname);
    }

    @Override
    public String QueryuserOnly(String uname, String uemile, String nickname) {
        return claramapper.QueryuserOnly(uname,uemile,nickname);
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
    public List<Menu> QueryByDetaileLike(String menutitle) {
        return claramapper.QueryByDetaileLike(menutitle);
    }


    @Override
    public void Fortitleid(int titleid,String menutitle) {
        claramapper.Fortitleid(titleid,menutitle);
    }

    @Override
    public String QueryById(int menuid) {
        return claramapper.QueryById(menuid);
    }

    @Override
    public List<String> QueryByIdall(List<Integer> menuid) {
        return claramapper.QueryByIdall(menuid);
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
    public int QueryTopiccommentscomment(String menutitle) {
        return claramapper.QueryTopiccommentscomment(menutitle);
    }

    @Override
    public int UpdateMenutitle(int menucomment,String menutitle) {
        return claramapper.UpdateMenutitle(menucomment,menutitle);
    }

    @Override
    public void UpadteMenured(String menutitle) {
        claramapper.UpadteMenured(menutitle);
    }

    @Override
    public List<RepleComments> QueryRepleComments(String repletitle) {
        return claramapper.QueryRepleComments(repletitle);
    }

    @Override
    public int ReplyComment(RepleComments repleComments) {
        return claramapper.ReplyComment(repleComments);
    }

    @Override
    public void id_rearrangement() {
        claramapper.id_rearrangement();
    }

    @Override
    public void id_rearrangement_() {
        claramapper.id_rearrangement_();
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
    public void deletetopiccomments(String menutitle) {
        claramapper.deletetopiccomments(menutitle);
    }

    @Override
    public void deletetopiccommentsall(List<String> menutitle) {
        claramapper.deletetopiccommentsall(menutitle);
    }

    @Override
    public int deleteMenuAll(List<Integer> list) {
        return claramapper.deleteMenuAll(list);
    }

    @Override
    public int addSongUrl(String songurl) {
        return claramapper.addSongUrl(songurl);
    }

    @Override
    public int AddMenu(Menu menu) {
        return claramapper.AddMenu(menu);
    }

}
