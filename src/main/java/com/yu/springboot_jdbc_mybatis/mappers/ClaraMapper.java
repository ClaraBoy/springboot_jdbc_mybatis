package com.yu.springboot_jdbc_mybatis.mappers;
import com.yu.springboot_jdbc_mybatis.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;
//相当于dao层
@Mapper//标识这是一个MapperDao接口主要实现和mapper.xml的联系
@Repository//被spring整合在这里可有可无
//前台接口
public interface ClaraMapper {//一个接口
    Users Queryuser(String uname);//用户登陆
    List<Users> Querynickname();//用户昵称
    String QueryuserOnly(String uname,String uemile,String nickname);//查询单个用户
    int addUser(Users users);//用户注册
    int UpdateUserPwd(VerificationVo verificationVo);//修改密码
    String QueryemileByNickname(String nickname);//获取邮箱
    int addLuckUser(String nickname,int sing);//音乐用户
    Song QuerySongUrl();//查询歌曲
     int UpdateSongNumber();//修改今日歌曲人数
    void DeleteLuckUser();//清空音乐用户
    void DeletSongUrl();//清空歌曲
    LuckUser QueryLuckUser(String nickname);//根据名称查询用户
    String queryNickName(String uname);    //查询单用户昵称
    int QueryAllMenuCount();//内容条数
    List<Menu> QueryAllMenuComments(int comments,String Review);//一个查询评论选项卡的方法
    List<Menu> QueryAllMenuYear(String year,String Review);//一个查询年选项卡的方法
    List<Menu> QueryLists(int RigHtTo,String Review);//普通全部内容
    String QueryUserNickName(String uname);//查询单个用户昵称







































    List<Menu> QueryAllMenuCommentsByPage(int comments,String Review,int start,int end);//一个查询评论文章选项卡的方法分页 弃用






















    List<MenuVo> QueryAllMenuYearByPage(String year,String Review,int start,int end,String applicationid);//一个查询年选项卡的方法分页
    List<MenuVo> QueryListsByPage(int RigHtTo,String Review,int start,int end);//普通全部内容分页



















    int QueryAllMenuCommentsByPageCount(int comments,String Review);//一个查询评论文章选项卡的方法数量


    int QueryAllMenuYearByPageCount(String year,String Review,String applicationid);//一个查询年文章选项卡的方法数量
    int QueryListsByPageCount(int RigHtTo,String Review);//普通全部内容数量





















    List<Menu> queryMenuList();//全部内容
    Menu QueryByDetails(String menutitle,String applicationid);//通过标题查询内容
    Menu QueryByDetailsExpand(String menutitle,String applicationid,String Review);//通过标题查询内容扩展
    Menu QueryByTitleMenu(String menuid);//根据menuid查询内容

















    List<Menu> QueryByDetaileLike(String menutitle,String Review);//根据标题模查询
    Set<String> QueryBySet(String menutitle,String Review);//联想查询
    List<Menu> QueryByDetaileLikePage(String menutitle,String Review,int start,int end);//通过标题查询内容 可分页
    List<String> QuerySearch(String userName);//查询搜素历史
    int addSearch(Search_history search_history);//添加搜索历史
    int deleteSearch(List<String> list,String userName);//删除搜索历史 包含多条和单条


















    //弃用
     void Fortitleid(int titleid,String menutitle,String applicationid);


























    String QueryById(int menuid);//通过id查标题单个

        //查询有文章用户







    String QueryByIdapplicationid(int menuid);//通过id查标题单个
    List<String> QueryByIdall(List<Integer> menuid);//通过id查标题多行
    Set<String> QueryByIdapplicationidall(List<Integer> menuid);//通过id查标题多行



    List<Topiccomments> QueryComment(String topictitle,String applicationid);//查询所有评论 ////////////////////////////////
    List<TopiccommentsVo> QueryCommentPage(String topictitle,String applicationid,int start,int end);//查询所有评论带分页 ////////////////////////////////
    String QueryMaxTopiccomment(String topictitle,String applicationid);//查询评论的层级最大层数
    int QueryTopiccommentRepleComments(String repletitle,String applicationid,int touid);//查询单个评论的回复数量 思路 查询文章下一个层数下回复的数量即可



    int addComment(Topiccomments topiccomments);//添加评论





    int QueryTopiccommentscomment(String menutitle,String applicationid);//查询Topiccomments的评论数方法1
    int UpdateMenutitle(int menucomment,String menutitle,String applicationid);//修改menu评论数条数方法2





    void UpadteMenured(String menutitle,String applicationid);//访问量



    List<RepleComments>QueryRepleComments(String repletitle,String applicationid);//根查询 //////////////////////////////////////////
    List<RepleComments>QueryRepleCommentsPage(String repletitle,String applicationid,int start,int end);//根查询带分页 //////////////////////////////////////////
    List<RepleComments> QueryRepleCommentsPageOnle(String repletitle,String applicationid,int touid,int start,int end);//查询评论下的回复 单查询





    int ReplyComment(RepleComments repleComments);//回复评论
    void addNotice(Notify notify);//添加通知
    List<Notify> queryNotify(String sender_name);//查询通知
    //全体通知（还需要把读过的人加入已读方法 还需要一张表保存已读用户）
    void updateNotify(String sender_name);//已读
    String queryusersupower(String upower);//查询用户权限




























//后台
    AdminInfo adminLogin(String adminName);//管理员登陆
    int updateAaminLastTime(String adminName);//管理员登陆时间修改
    int AddMenu(Menu menu);//添加menu
    int deleteMenu(int id);//删除menu
    int deleteDetails(int id);//删除内容
    void deletetopiccomments(String topictitle,String applicationid);//删除评论单个
    void deletereplecomments(String repletitle,String applicationid);//删除回复单个



    void deletetopiccommentsall(@Param("list0") List<String> topictitle,@Param("list1") List<String> applicationid);//删除评论多行
    void deletereplecommentsall(@Param("list0") List<String>  repletitle, @Param("list1") List<String> applicationid);//删除回复多行




    int deleteMenuAll(List<Integer> list);//批量删除
    int addSongUrl(String songurl);//插入歌曲
    @Transactional
    void id_rearrangement();//id rearrangement
    void id_rearrangement_();//id rearrangement



















    List<Topiccomments> queryTopiccomments(String menutitle,String applicationid);//查看所有评论信息
    List<RepleComments> queryRepleComments(String menutitle,String applicationid);//查看所有回复信息





















    List<Topiccomments> queryTopiccommentsandRepleComments(String menutitle); //查询连表评论与回复 无法使用 放弃使用
    int deleteTopiccomments(int id);//删除评论
    int deleteRepleComments(int id);//删除回复
    List<Menu> QueryTitlidMax(String applicationid); //客户下的文章集合
    int updateMenu(Menu menu);//修改文章
    int deleteR(String repletitle,String touid,String applicationid); //连带删除回复
    int selcttopiccommentsNum(String topictitle,String applicationid);//查询评论数
    int selctreplecommentsNum(String repletitle,String applicationid);//查询回复数
    int updateMenuCommentsNum(int menucomment,String menutitle,String applicationid);//更新文章评论数量

























    int addFocus(Focus focus);//关注功能实现
    int QueryByFocus(Focus focus);//查询是否关注
    int deleteByFocus(Focus focus);//删除关注

    int addCollect(Collect collect);//收藏功能实现
    int QueryByCollect(Collect collect);//查找是否收藏功能
    int deleteByCollect(Collect collect);//取消收藏功能

    int addManner(Manner manner);//点赞功能实现 一个接口
    int QueryByManner(Manner manner);//查询是否点赞
    int deleteByManner(Manner manner);//取消点赞功能
    //点赞核算功能

}