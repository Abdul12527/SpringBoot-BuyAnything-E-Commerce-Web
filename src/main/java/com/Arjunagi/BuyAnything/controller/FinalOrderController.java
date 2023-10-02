package com.Arjunagi.BuyAnything.controller;

import com.Arjunagi.BuyAnything.models.order.FinalOrder;
import com.Arjunagi.BuyAnything.services.FinalOrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FinalOrderController {
    @Autowired
    FinalOrderServices finalOrderServices;

    @PostMapping("/final/order")
    public String addFinalOrder(@RequestBody FinalOrder finalOrder){
        finalOrderServices.addFinalOrder(finalOrder);
        return "added sucessfully";
    }
    @GetMapping("/orders")
    public List<FinalOrder> getAll(){
        return finalOrderServices.getAll();
    }
}
