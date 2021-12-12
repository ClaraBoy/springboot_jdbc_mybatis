package com.yu.springboot_jdbc_mybatis.controller.attach;
import com.yu.springboot_jdbc_mybatis.pojo.ApplicationUser;
import com.yu.springboot_jdbc_mybatis.pojo.Menu;
import com.yu.springboot_jdbc_mybatis.server.attach.ServiceImpl;
import com.yu.springboot_jdbc_mybatis.server.original.ServicesImpl;
import com.yu.springboot_jdbc_mybatis.tool.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * @author 二十九
 * 附加功能
 */
@RestController
@CrossOrigin
@RequestMapping("/applicationCon")
public class AttachController {
    private ServicesImpl servicesImpl;
    @Autowired
    public void setServices(ServicesImpl servicesImpl) {
        this.servicesImpl = servicesImpl;
    }

    private ServiceImpl service;
        @Autowired
    public void setService(ServiceImpl service) {
        this.service = service;
    }
    @GetMapping("/applicationId")
    public List<ApplicationUser> queryAll(){
        return  service.queryall();
    }
    @GetMapping("/{application}")
    public int queryAppUser(@PathVariable("application") String application){
        System.out.println(application);
                return service.queryAppUser(application);
    }
    @PostMapping("add")
    public int addAppUser(@RequestBody ApplicationUser applicationUser){
                applicationUser.setApplicationdate(Token.getTime());
                applicationUser.setRemark1("no");
             //   System.out.println(applicationUser);
                int i = 0;
                try{
                     i= service.addAppUser(applicationUser);
                }catch (Exception e){
                   return i=400;
                }
              //  System.out.println(i);
                return i;
    }
    @PostMapping("updatePass/{applicationid}/{pOrn}")
    public int updatePass(@PathVariable("applicationid") String applicationid, @PathVariable("pOrn") String pOrn) throws IOException {
            if("yes".equals(pOrn)){
                return service.updatePass("yes",applicationid);
            }else{
                return service.deleteAppUser(applicationid);
            }
    }
    @PostMapping("updatePower/{uname}/{power}")
    public int updatePower(@PathVariable("uname") String uname,@PathVariable("power")String power){
            return service.updatePower(power,uname);
    }
    @PostMapping("addMenu")
    public int addMenu(@RequestParam("menutitle") String menutitle,
                       @RequestParam("menudate") String menudate,
                       @RequestParam("titleid") int titleid,
                       @RequestParam("info1") String info1,
                       @RequestParam("info1Url") String info1Url,
                       @RequestParam("info2") String info2,
                       @RequestParam("info2Url") String info2Url,
                       @RequestParam("rightto") int rightto,
                       @RequestParam("msg") String msg,
                       @RequestParam("applicationid") String applicationid){
        if(servicesImpl.QueryByDetails(menutitle,applicationid)==null){
            System.out.println("这是添加" + titleid);
            String Review="no";
            int s = servicesImpl.AddMenu(new Menu(0, menutitle, menudate, 0, 0, titleid, info1,info1Url, info2,info2Url, rightto, msg,applicationid,Review,0));
         //   System.out.println(s);
            if (s > 0) {
                Menu menu = servicesImpl.QueryByDetails(menutitle,applicationid);
                System.out.println(menu);
                System.out.println("这是id");
               // servicesImpl.Fortitleid(menu.getMenuid(), menu.getMenutitle(),menu.getApplicationid());
                return 1;
            }
        }
        return 0;//返回数据
    }
    @GetMapping("queryMenu/{applicationid}/{start}/{end}")
    public List<Menu> queryMenu(@PathVariable("applicationid") String applicationid,@PathVariable("start") int start,@PathVariable("end") int end){
            return service.queryMenu(applicationid,(start-1)*end,end);
    }
    @GetMapping("total/{applicationid}")
    public int total(@PathVariable("applicationid") String applicationid){
            return service.total(applicationid);
    }
    @PostMapping("/deleteAppMenu/{menuid}")
    public int deleteAppMenu(@PathVariable("menuid") int menuid){
            return service.deleteAppMenu(menuid);
    }
    @PostMapping("updateAppMenu")
    public int updateAppMenu(
            @RequestParam("menuid") int menuid,
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
    ){
            String Review="no";
           int i= service.updateAppMenu(new Menu(menuid, menutitle, menudate, 0, 0, titleid, info1,info1Url, info2,info2Url, rightto, msg,applicationid,Review,0));
        System.out.println("修改"+i);
            return i;
    }
}
