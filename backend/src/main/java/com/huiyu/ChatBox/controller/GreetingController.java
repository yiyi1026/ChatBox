package com.huiyu.ChatBox.controller;

import com.huiyu.ChatBox.model.Greeting;
import com.huiyu.ChatBox.model.Message;
import com.huiyu.ChatBox.model.RawMessage;
import com.huiyu.ChatBox.model.User;
import com.huiyu.ChatBox.repository.MessageRepository;
import com.huiyu.ChatBox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MessageRepository messageRepository;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(RawMessage rmsg) throws Exception {
        Thread.sleep(1000); // simulated delay
        persist(rmsg);
        return new Greeting(HtmlUtils.htmlEscape(rmsg.getName()) +": " + HtmlUtils.htmlEscape(rmsg.getMessage()));
    }

    private void persist(RawMessage rmsg) {
        User user;
        try {
            user = userRepository.findByName(rmsg.getName());
        } catch (Exception e) {
            user = new User(rmsg.getName());
            userRepository.save(user);
        }
        Message msg = new Message(user, rmsg.getMessage());
        messageRepository.save(msg);
    }

}
