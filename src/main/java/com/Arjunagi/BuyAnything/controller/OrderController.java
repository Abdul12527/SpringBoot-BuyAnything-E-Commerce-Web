package com.Arjunagi.BuyAnything.controller;

import com.Arjunagi.BuyAnything.models.order.UserOrder;
import com.Arjunagi.BuyAnything.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderServices orderServices;
    @PostMapping("/order")
    public void addOrder(@RequestBody UserOrder order){
        orderServices.addOrder(order);
    }
    @GetMapping("/orders")
    public List<UserOrder> getAllOrders(){
        return orderServices.getAllOrders();
    }
    @GetMapping("/order/id/{id}")
    public UserOrder getById(@PathVariable Integer id){
        return orderServices.getById(id);
    }
}
