package com.example.socket.controller;

import com.example.socket.dto.ResponseMessage;
import com.example.socket.services.WSService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WSController {

    private final WSService wsService;

    @PostMapping
    public void sendMessage(@RequestBody final String message) {
        this.wsService.notifyFrontEnd(message);
    }

    @PostMapping("{user-id}")
    public void sendPrivateMessage(@PathVariable(value = "user-id") String userId, @RequestBody final String message) {
        this.wsService.notifyFrontEnd(userId, message);
    }
}
