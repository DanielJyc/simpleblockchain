package com.danieljyc.websocket.client.impl;

import com.danieljyc.websocket.client.BlockchainWebSocketHandler;
import com.danieljyc.websocket.client.SendMessageClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

/**
 * Created by DanielJyc on 2017-11-05 17:07.
 */
@Component
public class SendMessageClientImpl implements SendMessageClient {
    private Log logger = LogFactory.getLog(SendMessageClientImpl.class);

    private static final String WS_URI = "ws://localhost:8012/reverse";

    @Override
    public void process() {

        BlockchainWebSocketHandler handler = new BlockchainWebSocketHandler();
        WebSocketClient client = new StandardWebSocketClient();
        try {
            WebSocketSession session = client.doHandshake(handler, WS_URI).get();
            session.sendMessage(new TextMessage("Hello World test."));
            session.close();
        } catch (Exception e) {
            logger.info(e);
        }
    }
}
