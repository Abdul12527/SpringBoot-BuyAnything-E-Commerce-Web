package com.Arjunagi.BuyAnything.controller;

import com.Arjunagi.BuyAnything.models.cartItem.CartItem;
import com.Arjunagi.BuyAnything.services.CartItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartItemController {
    @Autowired
    CartItemServices cartItemServices;
    @PostMapping("/cart/item")
    public void addOrder(@RequestBody CartItem order){
        cartItemServices.addOrder(order);
    }
    @GetMapping("/cart/items")
    public List<CartItem> getAllOrders(){
        return cartItemServices.getAllOrders();
    }
    @GetMapping("/cart/item/id/{id}")
    public CartItem getById(@PathVariable Integer id){
        return cartItemServices.getById(id);
    }
    @GetMapping("/cart/item/userid/{userId}")
    public List<CartItem> getAllByUserId(@PathVariable Integer userId){
        return cartItemServices.getByUserId(userId);
    }
    @DeleteMapping("/cart/item/id/{id}")
    public String deleteTheOrderById(@PathVariable Integer id){
        cartItemServices.deleteOrderById(id);
        return "cart item deleted";
    }
}
