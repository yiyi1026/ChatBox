package com.huiyu.ChatBox.controller;

import com.huiyu.ChatBox.model.*;
import com.huiyu.ChatBox.repository.ChannelRepository;
import com.huiyu.ChatBox.repository.MessageRepository;
import com.huiyu.ChatBox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Controller
public class RealTimeMessageController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ChannelRepository channelRepository;
    @Autowired
    MessageRepository messageRepository;

    @MessageMapping("/{channelname}")
    @SendTo("/channel/{channelname}")
    public Greeting message(@DestinationVariable String channelname, RawMessage rmsg) throws Exception {
        Thread.sleep(1000); // simulated delay
        Message message = persist(channelname, rmsg);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        simpleDateFormat1.setTimeZone(TimeZone.getTimeZone("US/Pacific"));

        return new Greeting(HtmlUtils.htmlEscape(message.getUser().getName()) +
                " [" +
                simpleDateFormat1.format(message.getCreated())
                + "] : " + HtmlUtils.htmlEscape(message.getMessage()));
    }

    private Message persist(String channelname, RawMessage rmsg) {
        User user = null;
        Channel channel = null;
        try {
            user = userRepository.findByName(rmsg.getName()).get();
        } catch (Exception e) {

        }
        if( user == null){
            user = new User(rmsg.getName());
            userRepository.save(user);
        }
        try {
            channel = channelRepository.findByName(channelname).get();
        } catch (Exception e) {

        }
        if( channel == null){
            channel = new Channel(channelname);
            channelRepository.save(channel);
        }

        Message msg = new Message(user, channel, rmsg.getMessage());
        messageRepository.save(msg);
        return msg;
    }

}
