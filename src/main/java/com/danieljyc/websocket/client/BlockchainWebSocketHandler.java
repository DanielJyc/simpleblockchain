package com.danieljyc.websocket.client;

import com.danieljyc.websocket.client.impl.SendMessageClientImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by DanielJyc on 2017-11-05 14:58.
 */
public class BlockchainWebSocketHandler extends TextWebSocketHandler {

    private Log logger = LogFactory.getLog(SendMessageClientImpl.class);

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        logger.info("------- received client message ------");
        logger.info(message.getPayload());
        logger.info("--------- end client message ---------");
    }
}
