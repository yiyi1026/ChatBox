package com.huiyu.ChatBox.repository;


import com.huiyu.ChatBox.model.Channel;
import com.huiyu.ChatBox.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findAll();

    List<Message> findByChannel(Channel channel);

    List<Message> findByCreatedBetween(Date from, Date to);

    List<Message> findByChannelAndCreatedBetween(Channel channel, Date from, Date to);
}
