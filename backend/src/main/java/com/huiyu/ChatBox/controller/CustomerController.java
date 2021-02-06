package com.huiyu.ChatBox.controller;

import com.huiyu.ChatBox.model.User;
import com.huiyu.ChatBox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    UserRepository repository;

    @RequestMapping("/bulkcreate")
    public String bulkcreate() {
        // save a single Customer
        try {
            repository.save(new User("b_user5"));

            // save a list of Customers
            repository.saveAll(Arrays.asList(new User("b_user1")
                    , new User("b_user2")
                    , new User("b_user3")
                    , new User("b_user4")));
        } catch (Exception e) {
            return "Customers creation failed";
        }
        return "Customers are created";
    }

    @CrossOrigin(allowCredentials = "true", originPatterns = "*")
    @RequestMapping("/findall")
    public List<User> findAll() {

        List<User> customers = repository.findAll();

        return customers;
    }
}
