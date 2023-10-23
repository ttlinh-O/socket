package com.example.socket.controller;

import com.example.socket.dto.Message;
import com.example.socket.dto.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

@Controller
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public ResponseMessage getMessage(@Payload Message message) throws InterruptedException {
        Thread.sleep(500);
        return new ResponseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));
    }


    @MessageMapping("/private-message")
    @SendToUser("/topic/private-messages")
    public ResponseMessage getPrivateMessage(@Payload Message message, Principal principal) throws InterruptedException {
        Thread.sleep(500);
        return new ResponseMessage(HtmlUtils.htmlEscape("sending private message to user: " + principal.getName() + " : "  + message.getMessageContent()));
    }
}
