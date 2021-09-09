package com.yu.springboot_jdbc_mybatis.controller.rabbitController;

import com.yu.springboot_jdbc_mybatis.controller.ClaraController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 二十九
 */
@RestController
public class SendMsgController {
    private static final Logger log = LoggerFactory.getLogger(ClaraController.class);
   private RabbitTemplate rabbitTemplate;
   @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() {
        log.debug("消息生产者");
        String messageId = "1";
        String messageData = "hello";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("testDirectExchange", "testDirectRouting", map);
        return "ok";
    }
}
