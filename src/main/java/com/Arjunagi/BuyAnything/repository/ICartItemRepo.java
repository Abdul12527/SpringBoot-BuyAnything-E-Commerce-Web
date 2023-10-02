package com.Arjunagi.BuyAnything.repository;


import com.Arjunagi.BuyAnything.models.cartItem.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICartItemRepo extends JpaRepository<CartItem,Integer> {
    List<CartItem> findByUserId(Integer userId);
}
