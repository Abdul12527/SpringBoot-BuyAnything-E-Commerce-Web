package com.Arjunagi.BuyAnything.services;

import com.Arjunagi.BuyAnything.models.payment.Payment;
import com.Arjunagi.BuyAnything.repository.IPaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServices {
    @Autowired
    IPaymentRepo paymentRepo;

    public void addPayment(Payment payment) {
        paymentRepo.save(payment);
    }

    public List<Payment> getAll() {
        return paymentRepo.findAll();
    }
}
