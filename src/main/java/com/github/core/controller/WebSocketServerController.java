package com.github.core.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.core.util.ApiReturnUtils;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author TonyTonyChopper
 */
@ServerEndpoint("/WebSocket/{userId}")
@Component
public class WebSocketServerController {

    private static Logger logger = LoggerFactory.getLogger(WebSocketServerController.class);

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的
     */
    private static int onlineCount = 0;

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象
     */
    private static ConcurrentHashMap<String, WebSocketServerController> websocketList = new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 接收userId
     */
    private String userId = "";

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        this.session = session;
        websocketList.put(userId, this);
        logger.info("WebSocketList->" + JSON.toJSONString(websocketList));
        //在线数加1
        addOnlineCount();
        logger.info("有新窗口开始监听:" + userId + ",当前在线人数为" + getOnlineCount());
        this.userId = userId;
        try {
            sendMessage(JSON.toJSONString(ApiReturnUtils.success("连接成功")));
        } catch (IOException e) {
            logger.error("WebSocket IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        websocketList.remove(this.userId);
        //在线数减1
        subOnlineCount();
        logger.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("收到来自窗口" + userId + "的信息:" + message);
        if (StringUtils.isNotBlank(message)) {
            JSONArray list = JSONArray.parseArray(message);
            for (int i = 0; i < list.size(); i++) {
                try {
                    //解析发送的报文
                    JSONObject object = list.getJSONObject(i);
                    String toUserId = object.getString("toUserId");
                    String contentText = object.getString("contentText");
                    object.put("fromUserId", this.userId);
                    //传送给对应用户的WebSocket
                    if (StringUtils.isNotBlank(toUserId) && StringUtils.isNotBlank(contentText)) {
                        WebSocketServerController socketX = websocketList.get(toUserId);
                        //需要进行转换，userId
                        if (socketX != null) {
                            socketX.sendMessage(JSON.toJSONString(ApiReturnUtils.success(object)));
                            //此处可以放置相关业务代码，例如存储到数据库
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message, @PathParam("userId") String userId) throws IOException {
        logger.info("推送消息到窗口" + userId + "，推送内容:" + message);
        for (Map.Entry<String, WebSocketServerController> next : websocketList.entrySet()) {
            WebSocketServerController nextValue = next.getValue();
            try {
                //这里可以设定只推送给这个userId的，为null则全部推送
                if (userId == null) {
                    nextValue.sendMessage(message);
                } else if (nextValue.userId.equals(userId)) {
                    nextValue.sendMessage(message);
                }
            } catch (IOException e) {
                logger.debug(e.getMessage());
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServerController.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServerController.onlineCount--;
    }


}
