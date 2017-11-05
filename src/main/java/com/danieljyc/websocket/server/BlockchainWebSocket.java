
package com.danieljyc.websocket.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;

@Component
@ServerEndpoint("/blockchain")
public class BlockchainWebSocket {
    private Log logger = LogFactory.getLog(BlockchainWebSocket.class);

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static AtomicLong onlineCount = new AtomicLong(0);

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的BlockchainWebSocket对象。
     */
    private static CopyOnWriteArraySet<BlockchainWebSocket> webSocketSet = new CopyOnWriteArraySet<BlockchainWebSocket>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;


    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void handleMessage(Session session, String message) {
        logger.info("Received msg: " + message);
        String sendMsg = "Reversed: " + new StringBuilder(message).reverse();
        try {
            session.getBasicRemote().sendText(sendMsg);
        } catch (IOException e) {
            logger.error("Send message error. Message: " + sendMsg);
        }
        logger.info("Send message: " + sendMsg);
    }

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpenWs(Session session) {
        this.session = session;
        webSocketSet.add(this);
        // 在线数加1
        incrementOnlinePeer();
        System.out.println("有新连接加入！当前连接数为：" + getOnlinePeers());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onCloseWs() {
        //从set中删除
        webSocketSet.remove(this);
        decrementOnlinePeer();
        logger.info("有一连接关闭！当前连接数为" + getOnlinePeers());
    }

    @OnError
    public void onErrorWs(Session session, Throwable error) {
        logger.info(String.format("Session %s,OnError: %s", session, error));
    }


    /**
     * 发送消息 message
     */
    private void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            logger.error("Send error.", e);
        }
    }

    /**
     * 广播
     */
    public static void sendMessageToAllPeers(String message) throws IOException {
        for (BlockchainWebSocket item : webSocketSet) {
            item.sendMessage(message);
        }
    }

    /**
     * 获取当前连接数
     */
    private static synchronized long getOnlinePeers() {
        return onlineCount.longValue();
    }

    /**
     * 当前连接数 +1
     */
    private static synchronized void incrementOnlinePeer() {
        onlineCount.incrementAndGet();
    }

    /**
     * 当前连接数 -1
     */
    private static synchronized void decrementOnlinePeer() {
        onlineCount.decrementAndGet();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
