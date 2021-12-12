package com.yu.springboot_jdbc_mybatis.tool;
import com.yu.springboot_jdbc_mybatis.server.original.ServicesImpl;
import lombok.SneakyThrows;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
//暂不使用此类
public  class  sendTime {
    static String executeTime = "00:00:00";
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static DateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
    static DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    public void sendTimeTo() {
        try {
            Class service= ServicesImpl.class;
            Method open=service.getMethod("DeleteLuckUser");
            open.invoke(service.newInstance(),null);
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
                            System.out.println("时间到了 清空数据");
                    }
                }
            }, 1000, 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
