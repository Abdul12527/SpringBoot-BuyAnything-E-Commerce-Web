package com.Arjunagi.BuyAnything.services;

import com.Arjunagi.BuyAnything.models.cartItem.CartItem;
import com.Arjunagi.BuyAnything.repository.ICartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServices {
    @Autowired
    ICartItemRepo orderRepo;
    public void addOrder(CartItem order) {
        orderRepo.save(order);
    }
    public List<CartItem> getAllOrders() {
        return orderRepo.findAll();
    }
    public CartItem getById(Integer id) {
        return orderRepo.findById(id).orElseThrow();
    }

    public void deleteOrderById(Integer id) {
        orderRepo.deleteById(id);
    }

    public List<CartItem> getByUserId(Integer userId) {
        return orderRepo.findByUserId(userId);
    }
}
