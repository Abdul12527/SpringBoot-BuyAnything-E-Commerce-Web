package com.Arjunagi.BuyAnything.repository;

import com.Arjunagi.BuyAnything.models.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPaymentRepo extends JpaRepository<Payment,Integer> {
}
