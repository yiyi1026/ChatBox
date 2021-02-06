package com.huiyu.ChatBox.controller;

import com.huiyu.ChatBox.model.Channel;
import com.huiyu.ChatBox.model.Message;
import com.huiyu.ChatBox.model.RequestMessage;
import com.huiyu.ChatBox.repository.ChannelRepository;
import com.huiyu.ChatBox.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class MessageController {
    @Autowired
    ChannelRepository channelRepository;
    @Autowired
    MessageRepository messageRepository;

    @RequestMapping(path = "/api/message")
    public Flux<Message> getMessage(RequestMessage requestMessage){
        Date from = requestMessage.getFrom();
        Date to = requestMessage.getTo();
        List<Message> messageList = new ArrayList<>();
        try{
            Channel channel = channelRepository.findByName(requestMessage.getChannel()).get();
            if ( from == null && to == null){
                messageList = messageRepository.findByChannel(channel);
            } else {
                if (to == null){
                    to = new Date();
                }
                if (from == null){
                    from = new Date(0);
                }
                messageList = messageRepository.findByChannelAndCreatedBetween(channel, from, to);
            }
        } catch (Exception e){
            // error
        }

        return Flux.fromStream(messageList.stream());
    }

//    @RequestMapping(path = "/api/message")
//    public String getMessage(RequestMessage requestMessage){
//        System.out.println(requestMessage.getChannel());
//        Channel channel = channelRepository.findByName(requestMessage.getChannel());
//        List<Message> messageList = messageRepository.findByChannel(channel);
//        if(messageList.size() == 0){
//            return "";
//        } else{
//            return messageList.get(0).toString();
//        }
//    }
}
