package com.huiyu.ChatBox.controller;

import com.huiyu.ChatBox.model.User;
import com.huiyu.ChatBox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    //    @PostMapping("/create")
//    public String create(@RequestBody CustomerUI customer){
//        // save a single Customer
//        repository.save(new User(customer.getFirstName(), customer.getLastName()));
//
//        return "Customer is created";
//    }
    @RequestMapping("/findall")
    public List<User> findAll() {

        List<User> customers = repository.findAll();

        return customers;
    }

//    @RequestMapping("/search/{id}")
//    public String search(@PathVariable long id){
//        String customer = "";
//        customer = repository.findById(id).toString();
//        return customer;
//    }
//
//    @RequestMapping("/searchbyfirstname/{firstname}")
//    public List<CustomerUI> fetchDataByLastName(@PathVariable String firstname){
//
//        List<Customer> customers = repository.findByFirstName(firstname);
//        List<CustomerUI> customerUI = new ArrayList<>();
//
//        for (Customer customer : customers) {
//            customerUI.add(new CustomerUI(customer.getFirstName(),customer.getLastName()));
//        }
//
//        return customerUI;
//    }
}
