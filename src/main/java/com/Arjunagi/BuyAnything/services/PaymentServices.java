package com.Arjunagi.BuyAnything.services;

import com.Arjunagi.BuyAnything.models.order.FinalOrder;
import com.Arjunagi.BuyAnything.models.order.FinalOrderStatus;
import com.Arjunagi.BuyAnything.models.payment.Payment;
import com.Arjunagi.BuyAnything.models.payment.PaymentStatus;
import com.Arjunagi.BuyAnything.repository.IFinalOrderRepo;
import com.Arjunagi.BuyAnything.repository.IPaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServices {
    @Autowired
    IPaymentRepo paymentRepo;
    @Autowired
    IFinalOrderRepo finalOrderRepo;
    @Autowired
    FinalOrderServices finalOrderServices;
    public void addPayment(Payment payment) {
        updateFinalOrderStatus(payment);
        paymentRepo.save(payment);
    }
    private void updateFinalOrderStatus(Payment payment){
        if(payment.getFinalOrder()!=null) {
            FinalOrder finalOrder=finalOrderRepo.findById(payment.getFinalOrder().getId()).orElseThrow();
            if (payment.getPaymentStatus() == PaymentStatus.SUCCESS) {
                finalOrder.setStatus(FinalOrderStatus.PlACED);
                if(finalOrder.getProducts()==null) {
                    finalOrderServices.addProductsFromCartIds(finalOrder);
                    finalOrderServices.deleteCartItems(finalOrder.getCartIds());
                }
            }
            if (payment.getPaymentStatus() == PaymentStatus.PROCESSING)
                finalOrder.setStatus(FinalOrderStatus.PROCESSING);
            if (payment.getPaymentStatus() == PaymentStatus.FAIL) finalOrder.setStatus(FinalOrderStatus.FAIL);


            finalOrderRepo.save(finalOrder);
        }

    }
    public List<Payment> getAll() {
        return paymentRepo.findAll();
    }

}
