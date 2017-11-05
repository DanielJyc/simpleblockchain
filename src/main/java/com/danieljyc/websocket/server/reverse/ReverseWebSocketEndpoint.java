/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.danieljyc.websocket.server.reverse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Component
@ServerEndpoint("/reverse")
public class ReverseWebSocketEndpoint {
    private Log logger = LogFactory.getLog(ReverseWebSocketEndpoint.class);

    @OnMessage
    public void handleMessage(Session session, String message) throws IOException {
        logger.info("Received msg: " + message);
        String sendMsg = "Reversed: " + new StringBuilder(message).reverse();
        session.getBasicRemote().sendText(sendMsg);
        logger.info("Send msg: " + sendMsg);
    }
}
