package com.Arjunagi.BuyAnything.models.cartItem;

import com.Arjunagi.BuyAnything.models.User;
import com.Arjunagi.BuyAnything.models.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    private Integer orderQuantity;
    @ManyToOne
    @JoinColumn(name = "fkUserId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "fkProduct")
    private Product products;
    private Status status;


}
