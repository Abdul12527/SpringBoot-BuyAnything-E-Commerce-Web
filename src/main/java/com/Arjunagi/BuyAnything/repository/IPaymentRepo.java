package com.Arjunagi.BuyAnything.repository;

import com.Arjunagi.BuyAnything.models.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepo extends JpaRepository<Payment,Integer> {
}
