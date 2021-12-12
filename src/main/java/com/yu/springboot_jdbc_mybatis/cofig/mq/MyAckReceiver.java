package com.yu.springboot_jdbc_mybatis.cofig.mq;
import com.rabbitmq.client.Channel;
import com.yu.springboot_jdbc_mybatis.pojo.Notify;
import com.yu.springboot_jdbc_mybatis.server.original.Services;
import com.yu.springboot_jdbc_mybatis.server.original.ServicesImpl;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

/**
 * @author 二十九
 * mq 消息处理
 */
@Component

public class MyAckReceiver implements ChannelAwareMessageListener {
    private ServicesImpl servicesImpl;
    @Autowired//把服务层注册到web
    public void setServicesImpl(ServicesImpl servicesImpl) {
        this.servicesImpl = servicesImpl;
    }

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            //因为传递消息的时候用的map传递,所以将Map从Message内取出需要做些处理
            String msg = message.toString();
            //可以点进Message里面看源码,单引号直接的数据就是我们的map消息数据
            String[] msgArray = msg.split("'");
            Map<String, String> msgMap = mapStringToMap(msgArray[1].trim(),3);
            String messageId=msgMap.get("messageId");
            String messageData= msgMap.get("messageData");
            String[] msgArray2;
           List<String> strings=new ArrayList<>();
                msgArray2 = messageData.split(",");
                for (String s : msgArray2) {
                    strings.add(s.replace("[","").replace("]",""));
            }
            String createTime=msgMap.get("createTime");
            System.out.println(strings.size());
            if ("testDirectQueue".equals(message.getMessageProperties().getConsumerQueue())){
                if(strings.get(0)!=null){
                    System.out.println("消费的消息来自的队列名为："+message.getMessageProperties().getConsumerQueue());
                    System.out.println("消息成功消费到  messageId:"+messageId+"  createTime:"+createTime);
                    System.out.println(strings.get(0)+strings.get(1));
                    System.out.println("执行TestDirectQueue中的消息的业务处理流程......");
                   String uname= servicesImpl.queryNickName(strings.get(0));
                    Notify notify=new Notify();
                    notify.setContent(strings.get(1))
                            .setType("0")
                            .setTarget_name("Clara")
                            .setAction("0")
                            .setSender_name(uname)
                            .setIs_read(0)
                            .setCreated_at(getTime());
                   // notify.
                    servicesImpl.addNotice(notify);
                }
                else{
                    System.out.println("消费的消息来自的队列名为："+message.getMessageProperties().getConsumerQueue()+"内容为空");
                }
            }
            if ("topic.man".equals(message.getMessageProperties().getConsumerQueue())){
                if(messageData.equals("hello")){
                    System.out.println("消费的消息来自的队列名为："+message.getMessageProperties().getConsumerQueue());
                    System.out.println("消息成功消费到  messageId:"+messageId+"  messageData:"+messageData+"  createTime:"+createTime);
                    System.out.println("执行topic.man中的消息的业务处理流程......");
                }
            }
            if ("topic.woman".equals(message.getMessageProperties().getConsumerQueue())){
                if(messageData.equals("hello")){
                    System.out.println("消费的消息来自的队列名为："+message.getMessageProperties().getConsumerQueue());
                    System.out.println("消息成功消费到  messageId:"+messageId+"  messageData:"+messageData+"  createTime:"+createTime);
                    System.out.println("执行topic.woman中的消息的业务处理流程......");
                }
            }
            //第二个参数，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
            channel.basicAck(deliveryTag, true);
//			channel.basicReject(deliveryTag, true);//第二个参数，true会重新放回队列，所以需要自己根据业务逻辑判断什么时候使用拒绝
        } catch (Exception e) {
            System.out.println("未消费");
            channel.basicReject(deliveryTag, false);
            e.printStackTrace();
        }
    }
    private Map<String, String> mapStringToMap(String str,int entryNum ) {
        str = str.substring(1, str.length() - 1);
        String[] strS = str.split(",",entryNum);
        Map<String, String> map = new HashMap<String, String>();
        for (String string : strS) {
            String key = string.split("=")[0].trim();
            String value = string.split("=")[1];
            map.put(key, value);
        }
        return map;
    }
    public String getTime() throws ParseException {
        StringBuffer sBuffer = new StringBuffer();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        System.out.println(sBuffer);
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
        DateFormat df7 = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.CHINA);
        String time1= df1.format(cal.getTime());
        String time2= df7.format(cal.getTime());
        return (time1+" "+time2);
    }
}
