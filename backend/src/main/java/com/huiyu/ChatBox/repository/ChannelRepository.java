package com.huiyu.ChatBox.repository;


import com.huiyu.ChatBox.model.Channel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChannelRepository extends CrudRepository<Channel, Long> {
    Channel findByName(String name);
    List<Channel> findAll();

}
