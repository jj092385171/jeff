package com.campingmapping.team4.spring.utils.controller.api;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.campingmapping.team4.spring.t401member.model.dto.Greeting;
import com.campingmapping.team4.spring.t401member.model.dto.HelloMessage;

@Controller
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000);
        return new Greeting("Hello, " + message.name() + "!");
    }

   

}
