package com.Arjunagi.BuyAnything.services;

import com.Arjunagi.BuyAnything.models.User;
import com.Arjunagi.BuyAnything.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    IUserRepo userRepo;

    public void addUser(User user) {
        userRepo.save(user);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User getbyId(Integer id) {
        return userRepo.findById(id).orElseThrow();
    }
}
