package com.Arjunagi.BuyAnything.services;

import com.Arjunagi.BuyAnything.models.order.UserOrder;
import com.Arjunagi.BuyAnything.repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServices {
    @Autowired
    IOrderRepo orderRepo;
    public void addOrder(UserOrder order) {
        orderRepo.save(order);
    }
    public List<UserOrder> getAllOrders() {
        return orderRepo.findAll();
    }
    public UserOrder getById(Integer id) {
        return orderRepo.findById(id).orElseThrow();
    }
}
