package com.yu.springboot_jdbc_mybatis.controller.shiroController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * @author 二十九
 * 查询特权的内容
 */
@RestController
@CrossOrigin
public class ShiroController {
//    @RequestMapping("/shiro/{username}/{pwd}")
//    public String login(@PathVariable("username") String username,@PathVariable("pwd") String pwd){
//        System.out.println(username+pwd);
//        UsernamePasswordToken shiroToken= new UsernamePasswordToken(username,pwd);
//        Subject subject= SecurityUtils.getSubject();
//        subject.login(shiroToken);
//            return "sess:"+subject.getSession().getId();
//    }
    @RequestMapping("/No_authorization")
    public String test3(){
        return "No authorization";
    }
    @RequestMapping("/member")
    public String test4(){
        return "Authorization succeeded";
    }
    @RequestMapping("/err")
    public String ooo(){
        return "err";
    }
}
