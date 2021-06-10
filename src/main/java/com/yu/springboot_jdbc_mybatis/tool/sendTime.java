package com.yu.springboot_jdbc_mybatis.tool;
import lombok.SneakyThrows;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
//暂时不使用的功能
public  class  sendTime {
    static  String executeTime = "15:30:00";
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static DateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
    static DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    static ArrayList<HashMap<String, String>> ReceiveMap=new ArrayList<>();
    public void sendTime(HashMap<String, String> map, String url,int s,String nickname) {
        ReceiveMap.add(map);
        try {
            //定时器
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                @SneakyThrows
                public void run() {
                    Date startTime = dateFormat.parse(dayFormat.format(new Date()) + " " + executeTime);
                    Date ti = dateFormat.parse(dayFormat.format(new Date()) + " " +timeFormat.format(new Date()));
                    System.out.println("当前时间" + ti.getTime());
                    System.out.println("固定时间" + startTime.getTime());
                    if (ti.getTime() == startTime.getTime()) {
                        try {
                            System.out.println(ReceiveMap.get(s).get(nickname));
                            System.out.println("时间到了 发送邮件");
                            //利用异常来跳出线程
                            int is=1/0;
                        }catch (Exception e){
                            System.out.println("结束线程");
                            throw new RuntimeException("模拟异常");
                        }
                    }
                }
            }, 1000, 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
