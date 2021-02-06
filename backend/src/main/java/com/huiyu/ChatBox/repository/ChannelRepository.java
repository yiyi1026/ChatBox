package com.huiyu.ChatBox.repository;


import com.huiyu.ChatBox.model.Channel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ChannelRepository extends CrudRepository<Channel, Long> {
    Optional<Channel> findByName(String name);
    List<Channel> findAll();

}
