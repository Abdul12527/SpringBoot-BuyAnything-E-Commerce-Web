package com.Arjunagi.BuyAnything.models.order;

import com.Arjunagi.BuyAnything.models.Address;
import com.Arjunagi.BuyAnything.models.User;
import com.Arjunagi.BuyAnything.models.cartItem.CartItem;
import com.Arjunagi.BuyAnything.models.payment.Payment;
import com.Arjunagi.BuyAnything.models.product.Product;
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
    private List<Integer> cartIds;
    @OneToMany
    @JoinColumn(name = "fkFinalOrderId")
    private List<Product> products;
    private Integer orderQuantity;
    @OneToOne
    @JoinColumn(name = "fkPaymentId")
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "fkaddress")
    private Address address;
    private FinalOrderStatus status;
}
