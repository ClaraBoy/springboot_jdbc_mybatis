package com.yu.springboot_jdbc_mybatis.server.original;
import com.yu.springboot_jdbc_mybatis.mappers.ClaraMapper;
import com.yu.springboot_jdbc_mybatis.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public  class ServicesImpl implements Services {
    @Autowired
    ClaraMapper claramapper;

    @Override
    public Users Queryuser(String uname) {
        return claramapper.Queryuser(uname);
    }

    @Override
    public List<Users> Querynickname() {
        return claramapper.Querynickname();
    }

    @Override
    public int addUser(Users users) {
        return claramapper.addUser(users);
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
    public List<Menu> QueryAllMenuComments(int comments,String Review) {
        return claramapper.QueryAllMenuComments(comments,Review);
    }

    @Override
    public String queryNickName(String uname) {
        return claramapper.queryNickName(uname);
    }

    @Override
    public List<Menu> QueryAllMenuYear(String year,String Review) {
        return claramapper.QueryAllMenuYear(year,Review);
    }

    @Override
    public int QueryAllMenuCount() {
        return claramapper.QueryAllMenuCount();
    }

    @Override
    public List<Menu> QueryLists(int RigHtTo,String Review){
        return claramapper.QueryLists(RigHtTo,Review);
    }

    @Override
    public String QueryUserNickName(String uname) {
        return claramapper.QueryUserNickName(uname);
    }

    @Override
    public List<Menu> QueryAllMenuCommentsByPage(int comments, String Review, int start, int end) {
        return claramapper.QueryAllMenuCommentsByPage(comments, Review, start, end);
    }

    @Override
    public List<MenuVo> QueryAllMenuYearByPage(String year, String Review, int start, int end,String applicationid) {
        return claramapper.QueryAllMenuYearByPage(year, Review, start, end,applicationid);
    }

    @Override
    public List<MenuVo> QueryListsByPage(int RigHtTo, String Review, int start, int end) {
        return claramapper.QueryListsByPage(RigHtTo, Review, start, end);
    }

    @Override
    public int QueryAllMenuCommentsByPageCount(int comments, String Review) {
        return claramapper.QueryAllMenuCommentsByPageCount(comments, Review);
    }

    @Override
    public int QueryAllMenuYearByPageCount(String year, String Review,String applicationid) {
        return claramapper.QueryAllMenuYearByPageCount(year, Review,applicationid);
    }

    @Override
    public int QueryListsByPageCount(int RigHtTo, String Review) {
        return claramapper.QueryListsByPageCount(RigHtTo, Review);
    }

    @Override
    public List<Menu> queryMenuList() {
        return claramapper.queryMenuList();
    }

    @Override
    public Menu QueryByDetails(String menutitle,String applicationid) {
        return claramapper.QueryByDetails(menutitle,applicationid);
    }

    @Override
    public Menu QueryByDetailsExpand(String menutitle, String applicationid, String Review) {
        return claramapper.QueryByDetailsExpand(menutitle,applicationid,Review);
    }

    @Override
    public Menu QueryByTitleMenu(String menuid) {
        return claramapper.QueryByTitleMenu(menuid);
    }

    @Override
    public List<Menu> QueryByDetaileLike(String menutitle,String Review) {
        return claramapper.QueryByDetaileLike(menutitle,Review);
    }

    @Override
    public Set<String> QueryBySet(String menutitle, String Review) {
        return claramapper.QueryBySet(menutitle, Review);
    }

    @Override
    public List<Menu> QueryByDetaileLikePage(String menutitle, String Review, int start, int end) {
        return claramapper.QueryByDetaileLikePage(menutitle, Review, start, end);
    }

    @Override
    public List<String> QuerySearch(String userName) {
        return claramapper.QuerySearch(userName);
    }

    @Override
    public int addSearch(Search_history search_history) {
        return claramapper.addSearch(search_history);
    }

    @Override
    public int deleteSearch(List<String> list, String userName) {
        return claramapper.deleteSearch(list,userName);
    }


    @Override
    public void Fortitleid(int titleid,String menutitle,String applicationid) {
        claramapper.Fortitleid(titleid,menutitle,applicationid);
    }

    @Override
    public String QueryById(int menuid) {
        return claramapper.QueryById(menuid);
    }

    @Override
    public String QueryByIdapplicationid(int menuid) {
        return claramapper.QueryByIdapplicationid(menuid);
    }

    @Override
    public List<String> QueryByIdall(List<Integer> menuid) {
        return claramapper.QueryByIdall(menuid);
    }

    @Override
    public Set<String> QueryByIdapplicationidall(List<Integer> menuid) {
        return claramapper.QueryByIdapplicationidall(menuid);
    }

    @Override
    public List<Topiccomments> QueryComment(String topictitle,String applicationid) {
        return claramapper.QueryComment(topictitle,applicationid);
    }

    @Override
    public int addComment(Topiccomments topiccomments) {
        return claramapper.addComment(topiccomments);
    }

    @Override
    public int QueryTopiccommentscomment(String menutitle,String applicationid) {
        return claramapper.QueryTopiccommentscomment(menutitle,applicationid);
    }

    @Override
    public int UpdateMenutitle(int menucomment,String menutitle,String applicationid) {
        return claramapper.UpdateMenutitle(menucomment,menutitle,applicationid);
    }

    @Override
    public void UpadteMenured(String menutitle,String applicationid) {
        claramapper.UpadteMenured(menutitle,applicationid);
    }

    @Override
    public List<RepleComments> QueryRepleComments(String repletitle,String applicationid) {
        return claramapper.QueryRepleComments(repletitle,applicationid);
    }

    @Override
    public int ReplyComment(RepleComments repleComments) {
        return claramapper.ReplyComment(repleComments);
    }

    @Override
    public void addNotice(Notify notify) {
        claramapper.addNotice(notify);
    }

    @Override
    public List<Notify> queryNotify(String sender_name) {
        return claramapper.queryNotify(sender_name);
    }

    @Override
    public void updateNotify(String sender_name) {
        claramapper.updateNotify(sender_name);
    }

    @Override
    public String queryusersupower(String upower) {
        return claramapper.queryusersupower(upower);
    }

    @Override
    public AdminInfo adminLogin(String adminName) {
        return claramapper.adminLogin(adminName);
    }

    @Override
    public int updateAaminLastTime(String adminName) {
        return claramapper.updateAaminLastTime(adminName);
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
    public void deletetopiccomments(String topictitle,String applicationid) {
        claramapper.deletetopiccomments(topictitle,applicationid);
    }

    @Override
    public void deletereplecomments(String repletitle, String applicationid) {
        claramapper.deletereplecomments(repletitle,applicationid);
    }

    @Override
    public void deletetopiccommentsall(List<String> topictitle,List<String> applicationid) {
        claramapper.deletetopiccommentsall(topictitle,applicationid);
    }

    @Override
    public void deletereplecommentsall(List<String> repletitle, List<String> applicationid) {
        claramapper.deletereplecommentsall(repletitle,applicationid);
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

    @Override
    public void id_rearrangement() {
        claramapper.id_rearrangement();
    }

    @Override
    public void id_rearrangement_() {
        claramapper.id_rearrangement_();
    }

    @Override
    public List<Topiccomments> queryTopiccomments(String menutitle,String applicationid) {
        return claramapper.queryTopiccomments(menutitle,applicationid);
    }

    @Override
    public List<TopiccommentsVo> QueryCommentPage(String topictitle, String applicationid, int start, int end) {
        return claramapper.QueryCommentPage(topictitle, applicationid, start, end);
    }

    @Override
    public String QueryMaxTopiccomment(String topictitle, String applicationid) {
        return claramapper.QueryMaxTopiccomment(topictitle, applicationid);
    }

    @Override
    public int QueryTopiccommentRepleComments(String repletitle, String applicationid, int touid) {
        return claramapper.QueryTopiccommentRepleComments(repletitle, applicationid, touid);
    }

    @Override
    public List<Menu> QueryTitlidMax(String applicationid) {
        return claramapper.QueryTitlidMax(applicationid);
    }

    @Override
    public List<RepleComments> queryRepleComments(String menutitle,String applicationid) {
        return claramapper.queryRepleComments(menutitle,applicationid);
    }

    @Override
    public List<RepleComments> QueryRepleCommentsPage(String repletitle, String applicationid, int start, int end) {
        return claramapper.QueryRepleCommentsPage(repletitle, applicationid, start, end);
    }

    @Override
    public List<RepleComments> QueryRepleCommentsPageOnle(String repletitle, String applicationid, int touid, int start, int end) {
        return claramapper.QueryRepleCommentsPageOnle(repletitle, applicationid, touid, start, end);
    }

    @Override
    public List<Topiccomments> queryTopiccommentsandRepleComments(String menutitle) {
        return claramapper.queryTopiccommentsandRepleComments(menutitle);
    }

    @Override
    public int deleteTopiccomments(int id) {
        return claramapper.deleteTopiccomments(id);
    }

    @Override
    public int deleteRepleComments(int id) {
        return claramapper.deleteRepleComments(id);
    }

    @Override
    public int deleteR(String repletitle, String touid,String applicationid) {
        return claramapper.deleteR(repletitle, touid,applicationid);
    }

    @Override
    public int updateMenu(Menu menu) {
        return claramapper.updateMenu(menu);
    }

    @Override
    public int selcttopiccommentsNum(String topictitle,String applicationid) {
        return claramapper.selcttopiccommentsNum(topictitle,applicationid);
    }

    @Override
    public int selctreplecommentsNum(String repletitle,String applicationid) {
        return claramapper.selctreplecommentsNum(repletitle,applicationid);
    }

    @Override
    public int updateMenuCommentsNum(int menucomment, String menutitle,String applicationid) {
        return claramapper.updateMenuCommentsNum(menucomment,menutitle,applicationid);
    }

    @Override
    public int addFocus(Focus focus) {
        return claramapper.addFocus(focus);
    }

    @Override
    public int QueryByFocus(Focus focus) {
        return claramapper.QueryByFocus(focus);
    }

    @Override
    public int deleteByFocus(Focus focus) {
        return claramapper.deleteByFocus(focus);
    }

    @Override
    public int addCollect(Collect collect) {
        return claramapper.addCollect(collect);
    }

    @Override
    public int deleteByCollect(Collect collect) {
        return claramapper.deleteByCollect(collect);
    }

    @Override
    public int QueryByCollect(Collect collect) {
        return claramapper.QueryByCollect(collect);
    }

    @Override
    public int addManner(Manner manner) {
        return claramapper.addManner(manner);
    }

    @Override
    public int QueryByManner(Manner manner) {
        return claramapper.QueryByManner(manner);
    }

    @Override
    public int deleteByManner(Manner manner) {
        return claramapper.deleteByManner(manner);
    }
}
