package com.yu.springboot_jdbc_mybatis.controller;
import com.yu.springboot_jdbc_mybatis.pojo.*;
import com.yu.springboot_jdbc_mybatis.server.Services;
import com.yu.springboot_jdbc_mybatis.tool.MailTool;
import com.yu.springboot_jdbc_mybatis.tool.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController//@Controller+@ResponseBody联用
// 但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
//@Controller//在对应的方法上，视图解析器可以解析return 的jsp,html页面，并且跳转到相应页面，若返回json等内容到页面，则需要加@ResponseBody注解
@CrossOrigin//跨域问题

public class ClaraController {
    @Autowired
    private MailTool mailTool;
    @Autowired//把服务层注册到web
    private Services services;
    @RequestMapping("/Ulogin")
    public LoginVo Queryuser(@RequestBody User info) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        User user=services.Queryuser(info.getUname());
        if(user!=null) {
            if(user.getUpwd().equals(info.getUpwd()))
            {
                Token Buildtoken=new Token();
                String Time=Buildtoken.getTime();
                Class login=Class.forName("com.yu.springboot_jdbc_mybatis.pojo.LoginVo");
                Constructor constructor=login.getDeclaredConstructor(Integer.class,Integer.class,String.class,String.class,String.class,String.class);
                String token=Buildtoken.sign(info.getUname(),Time);
                LoginVo loginVo= (LoginVo) constructor.newInstance(0,user.getUid(),info.getUname(),token,Time,user.getNickname());
                 System.out.println(loginVo);
                return loginVo;
            }
        }
        return new LoginVo();
    }
    @RequestMapping("/addUser")
    public int addUser(@RequestBody User registerinfo){
        System.out.println(registerinfo.getUemile());
        String info=services.QueryuserOnly(registerinfo.getUname(),registerinfo.getUemile(),registerinfo.getNickname());
        System.out.println(info);
        if(info==null) {
            int success = services.addUser(new User(
                    0,
                    registerinfo.getUname(),
                    registerinfo.getUpwd(),
                    registerinfo.getUemile(),
                    "普通",
                    registerinfo.getNickname()
            ));
            if (success == 1) {
                Map<String, Object> valueMap = new HashMap<String, Object>();
                valueMap.put("to", new String[]{registerinfo.getUemile()});
                valueMap.put("title","Clara Write");
                mailTool.sendSimpleMail(valueMap,0);
                return 1;
            }
        }else{
            return 0;
        }
        return 0;
    }
    @RequestMapping("/Querynickname")
    public List<User> Querynickname(){//查询昵称
        System.out.println("查询昵称");
        List<User> all=services.Querynickname();
        System.out.println(all);
        return all;
    }
    @RequestMapping("/Menucomments")
    public  List<Menu> QueryAllMenuComments(@RequestParam("comments") int comments){//返回评论数选项卡
       List<Menu> all= services.QueryAllMenuComments(comments);
        System.out.println(all);
        return all;//返回数据
    }
    @RequestMapping("/Menuyear")
    public  List<Menu> QueryAllMenuYear(@RequestParam("year") String year){//返回评论日期选项卡
        List<Menu> all= services.QueryAllMenuYear(year);
        System.out.println(all);
        return all;//返回数据
    }
    @RequestMapping("/queryLists")
        public  List<Menu> QueryLists(){//返回所有普通选项卡
        List<Menu> all= services.QueryLists(1);
        System.out.println(all);
        return all;//返回数据
    }
    @RequestMapping("/queryMenuList")
    public  List<Menu> queryMenuList(){//返回所有选项卡
        List<Menu> all= services.queryMenuList();
        System.out.println(all);
        return all;//返回数据
    }
    @RequestMapping("/QueryAllMenuCount")
    public int QueryAllDetailsCount(){//条数内容
        System.out.println("这是条数");
        System.out.println(services.QueryAllMenuCount());
        return services.QueryAllMenuCount();
        //返回数据
    }
    @RequestMapping("/Details")
    public Menu QueryByDetails(@RequestParam("menutitle") String menutitle){//返回所有内容
        System.out.println(menutitle);
        Menu all= services.QueryByDetails(menutitle);
        System.out.println(all);
        services.UpadteMenured(menutitle);
        return  all;
        //返回数据
    }
    //返回评论
    @RequestMapping("/QueryComment")
    public List<Topiccomments> QueryComment(@RequestParam("topictitle") String topictitle){
        List<Topiccomments> all=services.QueryComment(topictitle);
       // System.out.println("返回评论"+topictitle);
        return all;
    }
    //跳转发布评论
    @RequestMapping("/addComment")
    public void addComment(){
        System.out.println("这是发布评论");
    }
    @RequestMapping("/realaddComment")
    public int realaddComment(@RequestBody Topiccomments info){
        System.out.println("这是发布评论");
        info.setTopicdate(new Token().getTime());
        System.out.println(info);
        int back= services.addComment(info);
        //System.out.println(back);
        int menucomment= services.QueryTopiccommentscomment(info.getTopictitle());
        if(menucomment!=0){
                services.UpdateMenutitle(menucomment,info.getTopictitle());
        }
        return back;
    }
    @RequestMapping("/QueryRepleComments")
    public List<RepleComments> QueryRepleComments(@RequestParam("menutitle") String menutitle){
        List<RepleComments> all=services.QueryRepleComments(menutitle);
        System.out.println(all);
        System.out.println("这是根查询");
        return all;
    }
    //回复评论
    @RequestMapping("/replecomment")
    public int replecomment(@RequestBody RepleComments repleinfo){
        System.out.println(repleinfo);
       int back= services.ReplyComment(new RepleComments(0,repleinfo.getCommentid(),repleinfo.getRepleid(),repleinfo.getRepleType(),repleinfo.getRepletitle(),repleinfo.getRepletext(),repleinfo.getFromusid(),repleinfo.getTouid(),new Token().getTime()));
        return back;
    }
    //发送邮件
//    @RequestMapping("/sendmali")
//    public ModelAndView  sendmali(Model model){
//        System.out.println("这是邮件发送");
//        return new ModelAndView("index2");//重定向
//    }
    //发送验证码
   HashMap<String, Object> mapCode=new HashMap<String, Object>();
    @RequestMapping("/sendVerification")
    public int sendVerification(@RequestBody User resetpwdinfo){
        User user=services.Queryuser(resetpwdinfo.getUname());
        if(user!=null){
            if(user.getUemile().equals(resetpwdinfo.getUemile())){
                int max=99999,min=1000;
                long randomNum = System.currentTimeMillis();
                int ran3 = (int) (randomNum%(max-min)+min);
                HashMap<String, Object> map=new HashMap<>();
                map.put("title","Clara Write");
                map.put("to", new String[]{user.getUemile()});
               map.put("Verification",ran3+"");
               map.put("Nickname",user.getNickname());
                mailTool.sendSimpleMail(map,1);
                mapCode.put(user.getUname(),ran3+"");
                return 1;
            }
            return -1;
        }
        // System.out.println(geteali.getUname()+"/"+geteali.getUemile());
        return 0;
    }
    @RequestMapping("/verification")
   public Boolean verification(@RequestBody VerificationVo resetpwdinfo){
        System.out.println("本地验证码:"+mapCode.get(resetpwdinfo.getUname()));
        if(mapCode.get(resetpwdinfo.getUname())==null){
        return false;
        }
        if(mapCode.size()>0){
            if(mapCode.get(resetpwdinfo.getUname()).equals(resetpwdinfo.getVerificationCode())){
               int of= services.UpdateUserPwd(resetpwdinfo);
               if(of>=1){
                   Iterator<String> iterator = mapCode.keySet().iterator();
                   // 循环取键值进行判断
                   while (iterator.hasNext()) {
                       // 键
                       String key = iterator.next();
                       if (key.startsWith(resetpwdinfo.getUname())) {
                           // 移除map中以a字符开头的键对应的键值对
                           iterator.remove();
                       }
                   }
                   return true;
               }else{
                   return false;
               }
            }
            return false;
        }
        return false;
    }
}
