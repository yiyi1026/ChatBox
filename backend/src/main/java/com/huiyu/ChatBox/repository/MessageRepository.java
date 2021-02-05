package com.huiyu.ChatBox.repository;


import com.huiyu.ChatBox.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findAll();

}
