package com.Arjunagi.BuyAnything.models.order;

import com.Arjunagi.BuyAnything.models.Address;
import com.Arjunagi.BuyAnything.models.User;
import com.Arjunagi.BuyAnything.models.cartItem.CartItem;
import com.Arjunagi.BuyAnything.models.payment.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FinalOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "fkUserId")
    private User user;
    @OneToMany
    @JoinColumn(name = "fkFinalOrderId")
    private List<CartItem> cartItems;
    @ManyToOne
    @JoinColumn(name = "fkFinalOrderId")
    private Address address;
    @OneToOne
    @JoinColumn(name = "fkPaymentId")
    private Payment payment;
    private Status status;
}
