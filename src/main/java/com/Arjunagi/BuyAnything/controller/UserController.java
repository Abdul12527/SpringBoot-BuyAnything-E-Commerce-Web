package com.Arjunagi.BuyAnything.controller;

import com.Arjunagi.BuyAnything.models.User;
import com.Arjunagi.BuyAnything.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserServices userServices;
    @PostMapping("/user")
    public void addUser(User user){
        userServices.addUser(user);
    }
    @GetMapping("/users")
    public List<User> getAll(){
        return userServices.getAll();
    }
    @GetMapping("/user/id/{id}")
    public User getById(@PathVariable Integer id){
        return userServices.getbyId(id);
    }

}
