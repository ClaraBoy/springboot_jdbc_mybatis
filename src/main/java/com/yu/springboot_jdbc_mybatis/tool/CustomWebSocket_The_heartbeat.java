package com.yu.springboot_jdbc_mybatis.tool;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

//心跳测试
@ServerEndpoint(value = "/The_heartbeat")
@Component
public class CustomWebSocket_The_heartbeat {
    private static CopyOnWriteArraySet<CustomWebSocket_The_heartbeat> webSocketSetheart = new CopyOnWriteArraySet<CustomWebSocket_The_heartbeat>();
    private Session session;
    int i=0,j=0;
    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        webSocketSetheart.add(this);
        System.out.println("这是长连接"+i++);
    }
    @OnClose
    public void onClose() {
        //从set中删除
        webSocketSetheart.remove(this);
        System.out.println("关闭长连接"+j++);
    }
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("客户端发送请求保持连接的消息：" + message);
        if(message.equals("200")){
            System.out.println("保持连接");
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
