package com.yu.springboot_jdbc_mybatis.controller;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.Monitor;
import com.yu.springboot_jdbc_mybatis.cofig.shiro.CustomToken;
import com.yu.springboot_jdbc_mybatis.cofig.shiro.LoginType;
import com.yu.springboot_jdbc_mybatis.cofig.shiro.UserRealm;
import com.yu.springboot_jdbc_mybatis.pojo.*;
import com.yu.springboot_jdbc_mybatis.server.original.ServicesImpl;
import com.yu.springboot_jdbc_mybatis.tool.*;
import lombok.SneakyThrows;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
@RestController//@Controller+@ResponseBody联用
// 但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
//@Controller//在对应的方法上，视图解析器可以解析return 的jsp,html页面，并且跳转到相应页面，若返回json等内容到页面，则需要加@ResponseBody注解
@CrossOrigin
public class ClaraController {
    private static final String LOGIN_TYPE = LoginType.USER.toString();
    private static final Logger log = LoggerFactory.getLogger(ClaraController.class);
    private MailTool mailTool;

    @Autowired
    public void setMailTool(MailTool mailTool) {
        this.mailTool = mailTool;
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

    static Integer yys = 60;

    @PostConstruct
    public void sendTimeTo() {
        String executeTime = "00:00:00";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            //定时器
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                @SneakyThrows
                public void run() {
                    Date startTime = dateFormat.parse(dayFormat.format(new Date()) + " " + executeTime);
                    Date ti = dateFormat.parse(dayFormat.format(new Date()) + " " + timeFormat.format(new Date()));
                    // System.out.println("当前时间" + ti.getTime());
                    // System.out.println("固定时间" + startTime.getTime());
                    if (ti.getTime() == startTime.getTime()) {
                        System.out.println("时间到了 清空数据");
                        servicesImpl.DeletSongUrl();
                        servicesImpl.DeleteLuckUser();
                        yys = 60;
                    }
                }
            }, 1000, 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    final static Cache<String, String> cache = CacheBuilder.newBuilder()
            //设置cache的初始大小为10，要合理设置该值
            .initialCapacity(100)
            //设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作
            .concurrencyLevel(5)
            //设置cache中的数据在写入之后的存活时间为10秒
            .expireAfterWrite(500, TimeUnit.SECONDS)
            //构建cache实例
            .build();

    @RequestMapping("/Ulogin")
    public LoginVo Queryuser(@RequestBody Users info) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        log.debug("登陆操作");
        Users users = servicesImpl.Queryuser(info.getUname());
        if (users != null) {
            // shiro做权限认证
            //封装用户的登陆数据
            CustomToken shiroToken = new CustomToken(info.getUname(), info.getUpwd(), LOGIN_TYPE);
            //获取当前用户
            Subject subject = SecurityUtils.getSubject();
            //把信息给shiro
            //获取sessionid
            System.out.println("sessionid:" + subject.getSession().getId());
            try {
                subject.login(shiroToken);
                String Time = Token.getTime();
                Class login = Class.forName("com.yu.springboot_jdbc_mybatis.pojo.LoginVo");
                Constructor constructor = login.getDeclaredConstructor(Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class);
                String token = Token.sign(info.getUname(), Time, users.getUpwd());
                String refreshToken = Token.sign(info.getUname(), Time, users.getUpwd() + "refresh");
                LoginVo loginVo = (LoginVo) constructor.newInstance(0, users.getUid(), info.getUname(), token, refreshToken, Time, users.getNickname(), subject.getSession().getId(), users.getApplicationid());
                log.debug("LoginVo" + loginVo);
                HashMap map = new HashMap();
                map.put("token", token);
                map.put("uname", info.getUname());
                map.put("nickname", users.getNickname());
                HashMap map2 = new HashMap();
                map2.put("refreshToken", refreshToken);
                map2.put("uname", info.getUname());
                map2.put("nickname", users.getNickname());
                redisTemplate.opsForValue().set(users.getNickname() + "token", map);
                redisTemplate.opsForValue().set(users.getNickname() + "refreshToken", map2);
                return loginVo;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return new LoginVo();
        }
        return new LoginVo();
    }

    @RequestMapping("/addUser")
    public int addUser(@RequestBody Users registerinfo) {
        //  System.out.println(registerinfo.getUemile());
        String info = servicesImpl.QueryuserOnly(registerinfo.getUname(), registerinfo.getUemile(), registerinfo.getNickname());
        if (!"Clara".equals(registerinfo.getUname()) || !"clara".equals(registerinfo.getUname())) {
            if (info == null) {
                int success = servicesImpl.addUser(new Users(
                        0,
                        registerinfo.getUname(),
                        registerinfo.getUpwd(),
                        registerinfo.getUemile(),
                        "普通",
                        registerinfo.getNickname(),
                        registerinfo.getUname()
                ));
                if (success == 1) {
                    HashMap valueMap = new HashMap();
                    valueMap.put("to", new String[]{registerinfo.getUemile()});
                    valueMap.put("title", "Clara Write");
                    mailTool.sendSimpleMail(valueMap, 0);
                    return 1;
                }
            } else {
                return 0;
            }
        }
        return 0;
    }

    @RequestMapping("/Querynickname")
    public List<Users> Querynickname() {//查询昵称
        // System.out.println("查询昵称");
        List<Users> all = servicesImpl.Querynickname();
        //    System.out.println(all);
        return all;
    }

    @RequestMapping("/Menucomments")
    public List<Menu> QueryAllMenuComments(@RequestParam("comments") int comments, @RequestParam("Review") String Review) {//返回评论数选项卡
        List<Menu> all = servicesImpl.QueryAllMenuComments(comments, Review);
        //  System.out.println(all);
        return all;//返回数据
    }

    @RequestMapping("/Menuyear")
    public List<Menu> QueryAllMenuYear(@RequestParam("year") String year, @RequestParam("Review") String Review) {//返回评论日期选项卡
        // System.out.println(Review);
        List<Menu> all = servicesImpl.QueryAllMenuYear(year, Review);
        //System.out.println(all);
        return all;//返回数据
    }

    @RequestMapping("/queryLists")
    public List<Menu> QueryLists() {//返回所有普通选项卡
        List<Menu> all = servicesImpl.QueryLists(1, "yes");
        //  System.out.println(all);
        return all;//返回数据
    }

    @RequestMapping("/queryByTitleMenu")
    public Menu QueryByTitleMenu(@RequestParam("menuid") String menuid) {
        Menu menu = servicesImpl.QueryByTitleMenu(menuid);
        return menu;
    }

    @RequestMapping("/queryUserNickName")
    public String QueryUserNickName(@RequestParam("userName") String userName) {
        System.out.println(userName);
        return servicesImpl.QueryUserNickName(userName);
    }

//    @RequestMapping("/MenucommentsByPage")
//    public List<Menu> QueryAllMenuCommentsByPage(@RequestParam("comments") int comments,@RequestParam("Review") String Review,@RequestParam("start") int start,@RequestParam("end") int end) {//返回评论数选项卡
//        List<Menu> all = servicesImpl.QueryAllMenuCommentsByPage(comments,Review,(start-1)*end,end);
//        //  System.out.println(all);
//        return all;//返回数据
//    }

    @RequestMapping("/MenuyearByPage")
    public List<MenuVo> QueryAllMenuYearByPage(@RequestParam("year") String year, @RequestParam("Review") String Review, @RequestParam("start") int start, @RequestParam("end") int end) throws IOException {//返回评论日期选项卡
        List<MenuVo> all = servicesImpl.QueryAllMenuYearByPage(year, Review, (start - 1) * end, end, "rootClaraTo365");
//        for (int i=0;i<all.size();i++){
//            all.get(i).setMenuImage(Image.getImage(all.get(i).getMenutitle(), all.get(i).getApplicationid()));
//        }
        return all;//返回数据
    }

    @RequestMapping("/queryListsByPage")
    public List<MenuVo> QueryListsByPage(@RequestParam("start") int start, @RequestParam("end") int end) throws IOException {//返回所有普通选项卡
        List<MenuVo> all = servicesImpl.QueryListsByPage(1, "yes", (start - 1) * end, end);
        //  System.out.println(all);
//        for (int i=0;i<all.size();i++){
//            all.get(i).setMenuImage(Image.getImage(all.get(i).getMenutitle(), all.get(i).getApplicationid()));
//        }
        return all;//返回数据
    }


//    @RequestMapping("/MenucommentsByPageCount")
//    public int QueryAllMenuCommentsByPageCount(@RequestParam("comments") int comments,@RequestParam("Review") String Review) {//返回评论数选项卡
//        int Count = servicesImpl.QueryAllMenuCommentsByPageCount(comments,Review);
//        //  System.out.println(all);
//        return Count;//返回数据
//    }

    @RequestMapping("/MenuyearByPageCount")
    public int QueryAllMenuYearByPageCount(@RequestParam("year") String year, @RequestParam("Review") String Review) {//返回评论日期选项卡
        // System.out.println(Review);
        int Count = servicesImpl.QueryAllMenuYearByPageCount(year, Review, "rootClaraTo365");
        //System.out.println(all);
        return Count;//返回数据
    }

    @RequestMapping("/queryListsByPageCount")
    public int QueryListsByPageCount() {//返回所有普通选项卡
        int Count = servicesImpl.QueryListsByPageCount(1, "yes");
        //  System.out.println(all);
        return Count;//返回数据
    }


    @RequestMapping("/queryMenuList")
    public List<Menu> queryMenuList() {//返回所有选项卡
        List<Menu> all = servicesImpl.queryMenuList();
        // System.out.println(all);
        return all;//返回数据
    }

    @RequestMapping("/QueryAllMenuCount")
    public int QueryAllDetailsCount() {//条数内容
        //  System.out.println("这是条数");
        //  System.out.println(services.QueryAllMenuCount());
        return servicesImpl.QueryAllMenuCount();
        //返回数据
    }

    @RequestMapping("/Details")
    public Menu QueryByDetails(@RequestParam("menutitle") String menutitle, @RequestParam("applicationid") String applicationid) {//根据标题查询内容
        //  System.out.println(menutitle);
        Menu all = servicesImpl.QueryByDetails(menutitle, applicationid);
        // System.out.println(all);
        servicesImpl.UpadteMenured(menutitle, applicationid);
        return all;
        //返回数据
    }

    @RequestMapping("/DetailsExpand")
    public Menu QueryByDetailsExpand(@RequestParam("menutitle") String menutitle, @RequestParam("applicationid") String applicationid) {
        Menu all = servicesImpl.QueryByDetailsExpand(menutitle, applicationid, "yes");
        // System.out.println(all);
        servicesImpl.UpadteMenured(menutitle, applicationid);
        return all;
    }

    @RequestMapping("/DetaileLick")
    public List<Menu> DetaileLike(@RequestParam("menutitle") String menutitle) {
        //  System.out.println("模糊查询"+menutitle);
        List<Menu> all = servicesImpl.QueryByDetaileLike(menutitle, "yes");
        // System.out.println(all);
        return all;
    }

    @RequestMapping("/QueryBySet")
    public Set<String> QueryBySet(@RequestParam("menutitle") String menutitle) {
        Set<String> all = servicesImpl.QueryBySet(menutitle, "yes");
        return all;
    }

    @RequestMapping("/QueryByDetaileLikePage")
    public List<Menu> QueryByDetaileLikePage(@RequestParam("menutitle") String menutitle, @RequestParam("start") int start, @RequestParam("end") int end) {
        System.out.println(start + "/" + end);
        List<Menu> all = servicesImpl.QueryByDetaileLikePage(menutitle, "yes", (start - 1) * end, end);
        return all;
    }

    @RequestMapping("/search_history")
    public List<String> search_history(@RequestParam("userName") String userName) {
        System.out.println(userName);
        List<String> all = servicesImpl.QuerySearch(userName);
        return all;
    }

    @RequestMapping("/addSearch")
    public int addSearch(@RequestBody Search_history search_history) {
        System.out.println(search_history);
        return servicesImpl.addSearch(search_history);
    }

    @RequestMapping("/deleteSearch")
    public int deleteSearch(@RequestParam("delete") List delete, @RequestParam("userName") String userName) {
        return servicesImpl.deleteSearch(delete, userName);
    }

    //返回评论
    @RequestMapping("/QueryComment")
    public List<Topiccomments> QueryComment(@RequestParam("topictitle") String topictitle, @RequestParam("applicationid") String applicationid) {
        List<Topiccomments> all = servicesImpl.QueryComment(topictitle, applicationid);
        // System.out.println("返回评论"+topictitle);
        return all;
    }

    //查询所有评论带分页
    @RequestMapping("/QueryCommentPage")
    public List<TopiccommentsVo> QueryCommentPage(@RequestParam("topictitle") String topictitle, @RequestParam("applicationid") String applicationid,
                                                  @RequestParam("start") int start, @RequestParam("end") int end) {
        List<TopiccommentsVo> all = servicesImpl.QueryCommentPage(topictitle, applicationid, (start - 1) * end, end);
        for (int i = 0; i < all.size(); i++) {
            all.get(i).setNumber(servicesImpl.QueryTopiccommentRepleComments(all.get(i).getTopictitle(), all.get(i).getApplicationid(), all.get(i).getTopicred()));
        }
        return all;
    }

    //查询所有回复评论带分页
    @RequestMapping("/QueryRepleCommentsPage")
    public List<RepleComments> QueryRepleCommentsPage(@RequestParam("repletitle") String repletitle, @RequestParam("applicationid") String applicationid,
                                                      @RequestParam("start") int start, @RequestParam("end") int end) {
        return servicesImpl.QueryRepleCommentsPage(repletitle, applicationid, (start - 1) * end, end);
    }

    //查询所有回复评论带分页 单查询
    @RequestMapping("/QueryRepleCommentsPageOnle")
    public List<RepleComments> QueryRepleCommentsPageOnle(
            @RequestParam("repletitle") String repletitle,
            @RequestParam("applicationid") String applicationid,
            @RequestParam("touid") int touid,
            @RequestParam("start") int start,
            @RequestParam("end") int end) {
        return servicesImpl.QueryRepleCommentsPageOnle(repletitle, applicationid, touid, (start - 1) * end, end);
    }

    //跳转发布评论
    @RequestMapping("/addComment")
    public String addComment() {
        // System.out.println("这是发布评论");
        return "200";
    }

    public String getTime() throws ParseException {
        StringBuffer sBuffer = new StringBuffer();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        //  System.out.println(sBuffer);
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
        DateFormat df7 = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.CHINA);
        String time1 = df1.format(cal.getTime());
        String time2 = df7.format(cal.getTime());
        return (time1 + " " + time2);
    }

    @RequestMapping("/realaddComment")
    public int realaddComment(@RequestBody Topiccomments info) throws ParseException {
        //System.out.println(info);
        //  System.out.println("这是发布评论");

        info.setTopicdate(getTime());
        //    System.out.println(info);
        String commentMaxNumber = servicesImpl.QueryMaxTopiccomment(info.getTopictitle(), info.getApplicationid());
        System.out.println(commentMaxNumber + "////////////////////////////////////");
        if (commentMaxNumber == null) {
            info.setTopicred(0);
        } else {
            info.setTopicred(Integer.parseInt(commentMaxNumber) + 1);
        }
        int back = servicesImpl.addComment(info);
        //System.out.println(back);
        int menucomment = servicesImpl.QueryTopiccommentscomment(info.getTopictitle(), info.getApplicationid()); //查询评论数的方法
        if (menucomment != 0) {
            servicesImpl.UpdateMenutitle(menucomment, info.getTopictitle(), info.getApplicationid()); //修改文章评论数的方法
        }
        return back;
    }

    ///此处需要修改 重点 已改
    @RequestMapping("/QueryRepleComments")
    public List<RepleComments> QueryRepleComments(@RequestParam("menutitle") String menutitle, @RequestParam("applicationid") String applicationid) {
        List<RepleComments> all = servicesImpl.QueryRepleComments(menutitle, applicationid);
        //  System.out.println(all);
        //    System.out.println("这是根查询");
        return all;
    }

    //回复评论
    @RequestMapping("/replecomment")
    public int replecomment(@RequestBody RepleComments repleinfo) throws ParseException {
        //   System.out.println(repleinfo);
        Notify notify = new Notify();
        notify.setContent(repleinfo.getRepletext())
                .setType("回复")
                .setTarget_name(repleinfo.getCommentname())
                .setAction("用户")
                .setSender_name(repleinfo.getReplename())
                .setIs_read(0)
                .setCreated_at(getTime());
        servicesImpl.addNotice(notify);
        log.debug("" + repleinfo);
        int back = servicesImpl.ReplyComment(new RepleComments(0, repleinfo.getCommentname(), repleinfo.getReplename(), repleinfo.getRepleType(), repleinfo.getRepletitle(), repleinfo.getRepletext(), repleinfo.getFromusid(), repleinfo.getTouid(), Token.getTime(), repleinfo.getApplicationid()));
        return back;
    }

    //发送邮件
//    @RequestMapping("/sendmali")
//    public ModelAndView  sendmali(Model model){
//        System.out.println("这是邮件发送");
//        return new ModelAndView("index2");//重定向
//    }
    //发送验证码
    //HashMap<String, Object> mapCode=new HashMap<String, Object>();
    @RequestMapping("/sendVerification")
    public int sendVerification(@RequestBody Users resetpwdinfo) {
        Users users = servicesImpl.Queryuser(resetpwdinfo.getUname());
        if (users != null) {
            if (users.getUemile().equals(resetpwdinfo.getUemile())) {
                int max = 99999, min = 1000;
                long randomNum = System.currentTimeMillis();
                int ran3 = (int) (randomNum % (max - min) + min);
                HashMap<String, Object> map = new HashMap<>();
                map.put("title", "Clara Write");
                map.put("to", new String[]{users.getUemile()});
                map.put("Verification", ran3 + "");
                map.put("Nickname", users.getNickname());
                mailTool.sendSimpleMail(map, 1);
                cache.put(users.getUname(), ran3 + "");
                return 1;
            }
            return -1;
        }
        // System.out.println(geteali.getUname()+"/"+geteali.getUemile());
        return 0;
    }

    @RequestMapping("/verification")
    public Boolean verification(@RequestBody VerificationVo resetpwdinfo) {
        //验证码暂存
        //  System.out.println("本地验证码:" + cache.getIfPresent(resetpwdinfo.getUname()));
        if (cache.getIfPresent(resetpwdinfo.getUname()) == null) {
            return false;
        }
        if (cache.size() > 0) {
            if (cache.getIfPresent(resetpwdinfo.getUname()).equals(resetpwdinfo.getVerificationCode())) {
                int of = servicesImpl.UpdateUserPwd(resetpwdinfo);
                if (of >= 1) {
//                   Iterator<String> iterator = mapCode.keySet().iterator();
//                   // 循环取键值进行判断
//                   while (iterator.hasNext()) {
//                       // 键
//                       String key = iterator.next();
//                       if (key.startsWith(resetpwdinfo.getUname())) {
//                           // 移除map中以a字符开头的键对应的键值对
//                           iterator.remove();
//                       }
//                   }
                    cache.invalidate(resetpwdinfo.getUname());
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    //线程 用户签到
    private static final int MAX_SIZE = 0;
    private Monitor monitor = new Monitor();
    Monitor.Guard listBelowCapacity = new
            Monitor.Guard(monitor) {
                @Override
                public boolean isSatisfied() {
                    return yys > MAX_SIZE;
                }
            };

    public void Obtain() throws InterruptedException {
        // 超过MAX_SIZE， 会锁死
        //monitor.enterWhen(listBelowCapacity);
        // 超过返回false  不会锁死
        Boolean a = monitor.tryEnterIf(listBelowCapacity);
        try {
            // System.out.println("名额"+ servicesImpl.QuerySongUrl().getOfNumber());
            yys = servicesImpl.QuerySongUrl().getOfNumber();
            servicesImpl.UpdateSongNumber();
            System.out.println("获取成功" + yys--);
        } finally { // 确保线程会推出Monitor锁
            monitor.leave();
        }
    }

    LuckUser luckUser = null;
    Song song = null;

    @RequestMapping("/monitor/{nickname}/{token}")
    public String monitor(@PathVariable("nickname") String nickname, @PathVariable("token") String token) throws InterruptedException {
        // System.out.println(nickname+""+token);
        if (redisTemplate.opsForValue().get(nickname + "token") == null) {
            return "403";
        }
        luckUser = servicesImpl.QueryLuckUser(nickname);
        song = servicesImpl.QuerySongUrl();
        if (song == null) {
            return "系统暂未初始化";
        } else {
            if (luckUser == null) {
                try {
                    if (yys > 0) {
                        Obtain();
                        servicesImpl.addLuckUser(nickname, 1);
                        return song.getSongurl();
                    } else {
                        return "已无名额";
                    }
                } catch (Exception e) {
                    return "已无名额";
                }
            } else {
                return "你已拥有名额";
            }
        }
    }

    @PostMapping("/upNotify/{name}")
    public void updatenotify(@PathVariable("name") String name) {
        servicesImpl.updateNotify(name);
    }

    @GetMapping("/queryNotify/{name}")
    public List<Notify> queryNotify(@PathVariable("name") String name) {
        log.debug("" + name);
        return servicesImpl.queryNotify(name);
    }

    //id重排操作
//    @RequestMapping("/id_rearrangement")
//    public void id_rearrangement(){
//        servicesImpl.id_rearrangement();
//        servicesImpl.id_rearrangement_();
//    }
    @GetMapping("/outLogin/{uname}")
    public void outLogin(@PathVariable("uname") String uname) {
        //修改成功后清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        UserRealm userRealm = (UserRealm) securityManager.getRealms().iterator().next();
        userRealm.clearAllCache(uname);
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam("userName") String UserName) throws IOException {
        log.debug(file.getOriginalFilename());
        log.debug(String.valueOf(file.getSize()));
        log.debug(file.getContentType());
        String path = "E:\\test\\" + UserName + "\\";
        File file1 = new File(path);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        File files = new File(path + "Avatar" + "" + Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf(".")));
        file.transferTo(files);
        return "ok";
    }

    @ResponseBody
    @PostMapping("/upload1")
    public String upload1(@RequestParam("file") MultipartFile file, @RequestParam("userName") String UserName, @RequestParam("menutitle") String menutitle) throws IOException {
        log.debug(file.getOriginalFilename());
        log.debug(String.valueOf(file.getSize()));
        log.debug(file.getContentType());
        String path = "E:\\test\\" + UserName + "\\" + "menuImage" + "\\";
        File file1 = new File(path);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        File files = new File(path + menutitle + "" + Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf(".")));
        file.transferTo(files);
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/file/Avatar/{userName}", method = RequestMethod.GET)
    public void GetLogo(HttpServletRequest request, HttpServletResponse response, @PathVariable("userName") String userName) throws IOException {
        //获取用户输入的用户名
        System.out.println("图片");
        String filename = "Avatar" + ".jpg";  //根据用户名生成文件名
        String path = "E:\\test\\" + userName + "\\";
        File file = new File(path, filename);
        FileInputStream fis;
        fis = new FileInputStream(file);
        long size = file.length();
        byte[] data = new byte[(int) size];
        fis.read(data, 0, (int) size);
        fis.close();
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        out.write(data);
        out.flush();
        out.close();
    }

    @ResponseBody
    @RequestMapping(value = "/file/TitleImage/{userName}/{titleName}", method = RequestMethod.GET)
    public void GetLogoTitleImage(HttpServletRequest request, HttpServletResponse response, @PathVariable("userName") String userName, @PathVariable("titleName") String titleName) throws IOException {
        //获取用户输入的用户名
        String filename = titleName + ".jpg";  //根据用户名生成文件名
        String path = "E:\\test\\" + userName + "\\" + "menuImage" + "\\";
        File file = new File(path, filename);
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            long size = file.length();
            byte[] data = new byte[(int) size];
            fis.read(data, 0, (int) size);
            fis.close();
            response.setContentType("image/png");
            OutputStream out = response.getOutputStream();
            out.write(data);
            out.flush();
            out.close();
        } catch (Exception e) {
            String filename1 = "1.png";  //根据用户名生成文件名
            String path1 = "E:\\test\\错误\\menuImage";
            File file1 = new File(path1, filename1);
            FileInputStream fis1;
            fis1 = new FileInputStream(file1);
            long size = file1.length();
            byte[] data = new byte[(int) size];
            fis1.read(data, 0, (int) size);
            fis1.close();
            response.setContentType("image/png");
            OutputStream out = response.getOutputStream();
            out.write(data);
            out.flush();
            out.close();
            System.out.println(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/file/music", method = RequestMethod.GET)
    public void Getmusic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int max = 421;
        int min = 1;
        SecureRandom random = new SecureRandom();
        int s = random.nextInt(max) % (max - min + 1) + min;
        String filename = "1 (" + s + ")" + ".mp3";
        String path = "E:\\test\\";
        File file = new File(path, filename);
        FileInputStream fis;
        fis = new FileInputStream(file);
        long size = file.length();
        byte[] data = new byte[(int) size];
        fis.read(data, 0, (int) size);
        fis.close();
        response.setContentType("application/octet-stream");
        OutputStream out = response.getOutputStream();
        out.write(data);
        out.flush();
        out.close();
    }

    @PostMapping("/addFocus")
    public int addFocus(@RequestBody Focus focus) {
        return servicesImpl.addFocus(focus);
    }

    @PostMapping("/queryByFocus")
    public int QueryByFocus(@RequestBody Focus focus) {
        return servicesImpl.QueryByFocus(focus);
    }

    @PostMapping("/deleteByFocus")
    public int deleteByFocus(@RequestBody Focus focus) {
        return servicesImpl.deleteByFocus(focus);
    }

    @PostMapping("/addCollect")
    public int addCollect(@RequestBody Collect collect) {
        return servicesImpl.addCollect(collect);
    }

    @PostMapping("/deleteByCollect")
    public int deleteByCollect(@RequestBody Collect collect) {
        return servicesImpl.deleteByCollect(collect);
    }

    @PostMapping("/queryByCollect")
    public int queryByCollect(@RequestBody Collect collect) {
        return servicesImpl.QueryByCollect(collect);
    }

    @PostMapping("/MannerOperate")
    public int MannerOperate(@RequestBody Manner manner) {
        System.out.println(manner);
        if ("add".equals(manner.getManner())) {
            if(servicesImpl.addManner(manner)==1){
                return 1024;
            }
        }else if ("query".equals(manner.getManner())) {
            if(servicesImpl.QueryByManner(manner)==1){
                return 1024/2;
            }
        }
            servicesImpl.deleteByManner(manner);
                return 1024 / 4;

    }
}
