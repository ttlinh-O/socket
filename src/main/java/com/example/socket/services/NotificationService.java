package com.example.socket.services;

import com.example.socket.dto.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@SendTo
@RequiredArgsConstructor
public class NotificationService {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public void sendGlobalNotification() {
        ResponseMessage responseMessage = new ResponseMessage("Global Notification");
        simpMessagingTemplate.convertAndSend("/topic/global-notification", responseMessage);
    }

    public void sendPrivateNotification(String userId) {
        ResponseMessage responseMessage = new ResponseMessage("private Notification");
        simpMessagingTemplate.convertAndSendToUser(userId,"/topic/private-notification", responseMessage);
    }
}
