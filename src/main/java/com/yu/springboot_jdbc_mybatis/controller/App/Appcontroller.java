package com.yu.springboot_jdbc_mybatis.controller.App;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 二十九
 */
@CrossOrigin
@RestController
@RequestMapping("/App")
public class Appcontroller {
    //点赞数量的修改
    //是否关注修改
    //查询自己文章的关注数量
    //查找自己关注他人的文章
    @RequestMapping("/getToken")
    public String ps(HttpServletRequest request, HttpServletResponse response){
//        System.out.println("getToken");
        return "ok";
    }
}
