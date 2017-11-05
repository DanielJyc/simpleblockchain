package com.danieljyc.controller;

import com.danieljyc.websocket.client.SendMessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DanielJyc on 2017-11-05 17:13.
 */
@RestController
public class BlockchainDemo {

    @Autowired
    private SendMessageClient sendMessageClient;

    @RequestMapping(value = "/ws/{message}")
    public void sendMessage(@PathVariable("message") final String message) throws Exception {
        sendMessageClient.process();
    }

}
