package com.Arjunagi.BuyAnything.services;

import com.Arjunagi.BuyAnything.models.cartItem.CartItem;
import com.Arjunagi.BuyAnything.models.order.FinalOrder;
import com.Arjunagi.BuyAnything.models.order.FinalOrderStatus;
import com.Arjunagi.BuyAnything.models.payment.Payment;
import com.Arjunagi.BuyAnything.models.payment.PaymentStatus;
import com.Arjunagi.BuyAnything.models.product.Product;
import com.Arjunagi.BuyAnything.repository.ICartItemRepo;
import com.Arjunagi.BuyAnything.repository.IFinalOrderRepo;
import com.Arjunagi.BuyAnything.repository.IPaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinalOrderServices {
    @Autowired
    IFinalOrderRepo finalOrderRepo;
    @Autowired
    IPaymentRepo paymentRepo;
    @Autowired
    ICartItemRepo cartItemRepo;
    public void addFinalOrder(FinalOrder finalOrder) {
        setStatusBasedOnPayment(finalOrder);
        finalOrder.setOrderQuantity(finalOrder.getCartIds().size());
        if(!finalOrder.getStatus().equals(FinalOrderStatus.FAIL)) {
            addProductsFromCartIds(finalOrder);
            deleteCartItems(finalOrder.getCartIds());
        }else finalOrder.setProducts(null);
        finalOrderRepo.save(finalOrder);
    }
    private void setStatusBasedOnPayment(FinalOrder finalOrder){
        if(finalOrder.getPayment()!=null){
            Payment payment=paymentRepo.findById(finalOrder.getPayment().getId()).orElse(null);
            if(payment.getPaymentStatus().equals( PaymentStatus.SUCCESS))finalOrder.setStatus(FinalOrderStatus.PlACED);
            if(payment.getPaymentStatus().equals(PaymentStatus.PROCESSING))finalOrder.setStatus(FinalOrderStatus.PROCESSING);
            if(payment.getPaymentStatus().equals(PaymentStatus.FAIL)){
                finalOrder.setStatus((FinalOrderStatus.FAIL));
            }
        }else finalOrder.setStatus(FinalOrderStatus.PENDING);
    }
    protected void addProductsFromCartIds(FinalOrder finalOrder){
        List<CartItem> cartItems= cartItemRepo.findAllById(finalOrder.getCartIds());
        List<Product> products=new ArrayList<>();
        for(CartItem cartItem:cartItems)products.add(cartItem.getProducts());
        finalOrder.setProducts(products);
    }
    protected void deleteCartItems(List<Integer> cartItemIds ){
        cartItemRepo.deleteAllById(cartItemIds);
    }

    public List<FinalOrder> getAll() {
        return finalOrderRepo.findAll();
    }
}
