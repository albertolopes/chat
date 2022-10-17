package com.allo.chat.controller;

import com.allo.chat.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    private Message recevePublicMessage(@Payload Message message){
        return message;
    }

    @MessageMapping("/private-message")
    private Message recevePrivateMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(
                message.getReceverName(),
                "/private",
                message
        );
        return message;
    }

}
