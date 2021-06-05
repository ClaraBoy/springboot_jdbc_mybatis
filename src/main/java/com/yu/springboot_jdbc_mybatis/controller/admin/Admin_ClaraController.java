package com.yu.springboot_jdbc_mybatis.controller.admin;
import com.yu.springboot_jdbc_mybatis.pojo.Menu;
import com.yu.springboot_jdbc_mybatis.server.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@RestController//@Controller+@ResponseBody联用
// 但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
//@Controller//在对应的方法上，视图解析器可以解析return 的jsp,html页面，并且跳转到相应页面，若返回json等内容到页面，则需要加@ResponseBody注解
@CrossOrigin//跨域问题
public class Admin_ClaraController {
    @Autowired//把服务层注册到web
    private Services services;

    @RequestMapping("/deleteMenu")
    public int deleteMenu(@RequestParam("delete") List delete) {//删除内容 删除评论
        System.out.println("这是删除");
        System.out.println(delete);
        if (delete.size() <=1) {
            String meutitle = services.QueryById(Integer.parseInt(delete.get(0).toString()));
            services.deletetopiccomments(meutitle);
            services.deleteMenu(Integer.parseInt(delete.get(0).toString()));
            services.deleteDetails(Integer.parseInt(delete.get(0).toString()));
        }
        if (delete.size() > 1) {
            services.deletetopiccommentsall(services.QueryByIdall(delete));
            services.deleteMenuAll(delete);
        }
        return 0;//返回数据
    }

    @RequestMapping("/addMenu")
    public int addMenu(
            @RequestParam("menutitle") String menutitle,
            @RequestParam("menudate") String menudate,
            @RequestParam("titleid") int titleid,
            @RequestParam("info1") String info1,
            @RequestParam("info2") String info2,
            @RequestParam("rightto") int rightto,
            @RequestParam("msg") String msg
    ) {//添加menu
        if(services.QueryByDetails(menutitle)==null){
            System.out.println("这是添加" + titleid);
            int s = services.AddMenu(new Menu(0, menutitle, menudate, 0, 0, titleid, info1, info2, rightto, msg));
            if (s > 0) {
                Menu menu = services.QueryByDetails(menutitle);
                System.out.println("这是id");
                services.Fortitleid(menu.getMenuid(), menu.getMenutitle());
                return 1;
            }
        }
        return 0;//返回数据
    }

    @RequestMapping("/test")
    public int test() {
        return 1;
    }
}
