package com.yu.springboot_jdbc_mybatis.controller.admin;
import com.yu.springboot_jdbc_mybatis.cofig.shiro.CustomToken;
import com.yu.springboot_jdbc_mybatis.cofig.shiro.LoginType;
import com.yu.springboot_jdbc_mybatis.pojo.*;
import com.yu.springboot_jdbc_mybatis.server.attach.ServiceImpl;
import com.yu.springboot_jdbc_mybatis.server.original.ServicesImpl;
import com.yu.springboot_jdbc_mybatis.tool.Token;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@RestController//@Controller+@ResponseBody联用
// 但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
//@Controller//在对应的方法上，视图解析器可以解析return 的jsp,html页面，并且跳转到相应页面，若返回json等内容到页面，则需要加@ResponseBody注解
@CrossOrigin//跨域问题
public class Admin_ClaraController {
    private static final String LOGIN_TYPE= LoginType.ADMIN.toString();
    private ServiceImpl service;
    @Autowired//把服务层注册到web
    public void setService(ServiceImpl service) {
        this.service = service;
    }

    private ServicesImpl servicesImpl;
    @Autowired//把服务层注册到web
    public void setServices(ServicesImpl servicesImpl) {
        this.servicesImpl = servicesImpl;
    }
    private RedisTemplate redisTemplate;
    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @RequestMapping("/deleteMenu")
    public int deleteMenu(@RequestParam("delete") List delete) {//删除内容 删除评论 和回复
        System.out.println("这是删除");
        System.out.println(delete);
        if (delete.size() <=1) {
            String menutitle = servicesImpl.QueryById(Integer.parseInt(delete.get(0).toString()));
            String menuapplicationid= servicesImpl.QueryByIdapplicationid(Integer.parseInt(delete.get(0).toString()));
       //     System.out.println(menutitle+"/"+menuapplicationid);
            servicesImpl.deletetopiccomments(menutitle,menuapplicationid);
            servicesImpl.deletereplecomments(menutitle,menuapplicationid);
            servicesImpl.deleteMenu(Integer.parseInt(delete.get(0).toString()));
            servicesImpl.deleteDetails(Integer.parseInt(delete.get(0).toString()));
        }
        if (delete.size() > 1) {
           // System.out.println(servicesImpl.QueryByIdall(delete));
            Set<String> set= servicesImpl.QueryByIdapplicationidall(delete);
            List<String> list=new ArrayList();
            set.forEach(value->{ list.add(value); });
           // System.out.println(list);
            servicesImpl.deletetopiccommentsall(servicesImpl.QueryByIdall(delete),list);
            servicesImpl.deletereplecommentsall(servicesImpl.QueryByIdall(delete),list);
            servicesImpl.deleteMenuAll(delete);
        }
        return 0;//返回数据
    }
    @RequestMapping("/addMenu")
    public int addMenu(
            @RequestParam("menutitle") String menutitle,
            @RequestParam("menudate") String menudate,
            @RequestParam("titleid") int titleid,
            @RequestParam("info1") String info1,
            @RequestParam("info1Url") String info1Url,
            @RequestParam("info2") String info2,
            @RequestParam("info2Url") String info2Url,
            @RequestParam("rightto") int rightto,
            @RequestParam("msg") String msg,
            @RequestParam("applicationid") String applicationid
    ) {//添加menu
        if(servicesImpl.QueryByDetails(menutitle,applicationid)==null){
          //  System.out.println("这是添加" + titleid);
            String Review="yes";
            int s = servicesImpl.AddMenu(new Menu(0, menutitle, menudate, 0, 0, titleid, info1,info1Url, info2,info2Url, rightto, msg,applicationid,Review,0));
           // System.out.println(s);
            if (s > 0) {
                Menu menu = servicesImpl.QueryByDetails(menutitle,applicationid);
             //   System.out.println(menu);
             //   System.out.println("这是id");
               // servicesImpl.Fortitleid(menu.getMenuid(), menu.getMenutitle(),menu.getApplicationid());
                return 1;
            }
        }
        return 0;//返回数据
    }
        @RequestMapping("/addSongUrl")//插入url数据
        public String addSongUrl(@RequestParam("songurl") String songurl){
        if(servicesImpl.QuerySongUrl()==null){
            servicesImpl.addSongUrl(songurl);
            return "成功";
        }else{
            return "今日已上传";
        }
        }
    @RequestMapping("/test")
    public int test() {
        return 1;
    }
    @GetMapping("/topiccomments/{menutitle}/{applicationid}")
    public List<Topiccomments> queryreplecomments(@PathVariable("menutitle") String menutitle,@PathVariable("applicationid") String applicationid){
        return servicesImpl.queryTopiccomments(menutitle,applicationid);
    }
    @GetMapping("/replecomments/{menutitle}/{applicationid}")
    public List<RepleComments> queryrreplecomments(@PathVariable("menutitle") String menutitle,@PathVariable("applicationid") String applicationid){
        return servicesImpl.queryRepleComments(menutitle,applicationid);
    }
    @GetMapping("/TopiccommentsAndRepleComments/{menutitle}")
    public List<Topiccomments> queryTopiccommentsandRepleComments(@PathVariable("menutitle") String menutitle){
        return servicesImpl.queryTopiccommentsandRepleComments(menutitle);
    }
    @GetMapping("/deletetopiccomments/{id}/{menutitle}/{topicred}/{applicationid}")
    public int deleteTopiccomments(@PathVariable("id") int id,@PathVariable("menutitle") String menutitle,@PathVariable("topicred") String topicred,@PathVariable("applicationid") String applicationid){
        //连带删除回复表
       // System.out.println(applicationid);
        servicesImpl.deleteR(menutitle,topicred,applicationid);
        return servicesImpl.deleteTopiccomments(id);
    }
    @GetMapping("/deletereplecomments/{id}")
    public int deleteRepleComments(@PathVariable("id") int id){
     //   System.out.println(66666);
        return servicesImpl.deleteRepleComments(id);
    }
    @GetMapping("querytitle/{titleName}/{applicationid}")
    public Menu QueryByDetails(@PathVariable("titleName") String titleName,@PathVariable("applicationid") String applicationids){
        return servicesImpl.QueryByDetails(titleName,applicationids);
    }
    @PostMapping("updateMenu")
    public int updateMenu(@RequestBody Menu menu){
        System.out.println(menu);
        return servicesImpl.updateMenu(menu);
    }
    //修改文章评论的数量
    @RequestMapping("updateMenuCommentsNum/{menuTitle}/{applicationid}")
    public int updateMenuCommentsNum(@PathVariable("menuTitle") String menuTitle,@PathVariable("applicationid") String applicationid){
        int num=0;
        num+= servicesImpl.selcttopiccommentsNum(menuTitle,applicationid);
        num+= servicesImpl.selctreplecommentsNum(menuTitle,applicationid);
        int i= servicesImpl.updateMenuCommentsNum(num,menuTitle,applicationid);
            return i;
    }
    @RequestMapping("adminLogin")
    public AdminLoginVo adminLogin(@RequestBody AdminInfo adminInfoWeb){
       AdminInfo adminInfo= servicesImpl.adminLogin(adminInfoWeb.getAdminName());
        if(adminInfo!=null){
            CustomToken usernamePasswordToken=new CustomToken(adminInfo.getAdminName(),adminInfoWeb.getAdminpwd(),LOGIN_TYPE);
            Subject subject= SecurityUtils.getSubject();
            try{
                subject.login(usernamePasswordToken);
                String Time = Token.getTime();
                String token= Token.sign(adminInfo.getAdminName(),Time,adminInfo.getAdminpwd());
                AdminLoginVo adminLoginVo=new AdminLoginVo();
                adminLoginVo.setName(adminInfo.getAdminName());
                adminLoginVo.setImageUrl(adminInfo.getImageUrl());
                adminLoginVo.setUpower(adminInfo.getUpower());
                adminLoginVo.setLastTime(Time);
                adminLoginVo.setToken(token);
                HashMap map=new HashMap();
                map.put("token",token);
                map.put("adminuname",adminInfo.getAdminName());
                redisTemplate.opsForValue().set(adminInfo.getAdminName()+"adminSroottoken",map,90*60);
                if(servicesImpl.updateAaminLastTime(adminInfo.getAdminName())==1){
                    return adminLoginVo;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return new AdminLoginVo();
    }
















    @GetMapping("/queryMenuNo/{Review}")
    public List<Menu> queryMenuNo(@PathVariable("Review") String Review){
        return service.queryMenuNo(Review);
    }








    @GetMapping("/queryMenuOnle/{menuid}")
    public Menu queryMenuOnle(@PathVariable("menuid") String menuid){
        return service.queryMenuOnle(menuid);
    }
    @PostMapping("/passMenu/{menuid}")
    public int passMenu(@PathVariable("menuid") String menuid){
      //  System.out.println("pass");
        return service.passMenu(menuid);
    }

}
