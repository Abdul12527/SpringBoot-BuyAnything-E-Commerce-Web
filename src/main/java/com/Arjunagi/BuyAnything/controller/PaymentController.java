package com.Arjunagi.BuyAnything.controller;

import com.Arjunagi.BuyAnything.models.payment.Payment;
import com.Arjunagi.BuyAnything.services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    PaymentServices paymentServices;

    @PostMapping("/payment")
    public String addPayment(@RequestBody Payment payment){
        paymentServices.addPayment(payment);
        return "payment don sucessfully";
    }
    @GetMapping("/payments")
    public List<Payment> getAll(){
        return paymentServices.getAll();
    }

}
