package com.yu.springboot_jdbc_mybatis.controller.rabbitController;
import com.yu.springboot_jdbc_mybatis.controller.ClaraController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    @GetMapping("/sendDirectMessage/{userName}/{msg}")
    public String sendDirectMessage(@PathVariable("userName")String userName,@PathVariable("msg")String msg) {
        log.debug("消息生产者直连交换机"+userName,msg);
        String messageId = "1"; //重要内容id 不可重复
        String messageData = "hello";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        if(!userName.equals("")&&!msg.equals("")){
            List<String> msgs=new ArrayList<>();
            msgs.add(userName);
            msgs.add(msg);
            Map<String,Object> map=new HashMap<>();
            map.put("messageId",messageId);
            map.put("messageData",msgs);
            map.put("createTime",createTime);
            //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
            rabbitTemplate.convertAndSend("testDirectExchange", "testDirectRouting", map);
            return "ok";
        }
        return "error";


    }
    @GetMapping("/sendDirectMessage2")
    public String sendDirectMessage2() {
        log.debug("消息生产者主题交换机");
        String messageId = "2"; //重要内容id 不可重复
        String messageData = "hello";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", map);
        return "ok";
    }
    @GetMapping("/sendDirectMessage3")
    public String sendDirectMessage3() {
        log.debug("消息生产者主题交换机");
        String messageId = "3"; //重要内容id 不可重复
        String messageData = "hello";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("topicExchange", "topic.woman", map);
        return "ok";
    }
}
