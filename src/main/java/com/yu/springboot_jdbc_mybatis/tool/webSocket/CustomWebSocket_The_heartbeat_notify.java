package com.yu.springboot_jdbc_mybatis.tool.webSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

//心跳测试 心跳 使用于页面更新
@CrossOrigin//跨域问题
@ServerEndpoint(value = "/The_heartbeat_notify")
@Component
public class CustomWebSocket_The_heartbeat_notify {
    private static CopyOnWriteArraySet<CustomWebSocket_The_heartbeat_notify> webSocketSetheart = new CopyOnWriteArraySet<CustomWebSocket_The_heartbeat_notify>();
    private static final Logger log = LoggerFactory.getLogger(CustomWebSocket_The_heartbeat_notify.class);
    private Session session;
    int i=0,j=0;
    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        webSocketSetheart.add(this);
        log.debug("这是长连接");
    }
    @OnClose
    public void onClose() {
        //从set中删除
        webSocketSetheart.remove(this);
        log.debug("关闭长连接"+j++);
    }
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.debug("客户端发送请求保持连接的消息"+message);
        if(message.equals("200")){
            log.debug("保持连接");
            sendMessage("200");
        }else {
            sendMessage("400");
        }
    }
    public void sendMessage(String message) throws IOException {
        //获取session远程基本连接发送文本消息
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("----websocket-------有异常啦");
        error.printStackTrace();
    }
}
