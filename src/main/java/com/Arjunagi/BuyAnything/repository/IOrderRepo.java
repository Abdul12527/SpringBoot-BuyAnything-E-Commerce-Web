package com.Arjunagi.BuyAnything.repository;


import com.Arjunagi.BuyAnything.models.order.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<UserOrder,Integer> {
}
