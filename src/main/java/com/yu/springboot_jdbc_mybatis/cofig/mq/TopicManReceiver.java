package com.yu.springboot_jdbc_mybatis.cofig.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 二十九
 * 暂不使用
 */
@Component
@RabbitListener(queues = "topic.man")
public class TopicManReceiver {

    @RabbitHandler
    public void process(Map testMessage) {
       // System.out.println("TopicManReceiver消费者收到消息  : " + testMessage.toString());
    }
}
