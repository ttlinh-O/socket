package com.example.socket.services;

import com.example.socket.dto.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WSService {
    private final SimpMessagingTemplate simpMessageTemplate;

    public void notifyFrontEnd(String message) {
        ResponseMessage responseMessage = new ResponseMessage(message);
         this.simpMessageTemplate.convertAndSend("/topic/messages", responseMessage);
    }

    public void notifyFrontEnd(String userID, String message) {
        ResponseMessage responseMessage = new ResponseMessage(message);
        this.simpMessageTemplate.convertAndSendToUser(userID,"/topic/messages", responseMessage);
    }
}
