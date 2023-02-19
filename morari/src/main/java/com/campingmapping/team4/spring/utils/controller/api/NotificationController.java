package com.campingmapping.team4.spring.utils.controller.api;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.campingmapping.team4.spring.t401member.model.dto.Notification;
import com.campingmapping.team4.spring.utils.service.JwtService;

import jakarta.servlet.http.HttpServletRequest;

// @Controller
// public class NotificationController {
//     @Autowired
//     private SimpMessagingTemplate messagingTemplate;
//     @Autowired
//     private JwtService jwtService;

//     @PostMapping("/send-notification")
//     public void sendNotification(@RequestParam("message") String message, HttpServletRequest request) {
//         UUID targetUserUuid = jwtService.getUId(request);
//         messagingTemplate.convertAndSendToUser(targetUserUuid.toString(), "/queue/notifications",
//                 new Notification(message));
//     }

//     @PostMapping("/send-notification")
//     public void sendNotification(@RequestParam("message") String message) {
//         messagingTemplate.convertAndSend("/topic/notifications", new Notification(message));
//     }

// }