package com.huiyu.ChatBox.repository;


import com.huiyu.ChatBox.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
    List<User> findAll();

}
