package com.Arjunagi.BuyAnything.models.cartItem;

import com.Arjunagi.BuyAnything.models.User;
import com.Arjunagi.BuyAnything.models.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fkUserId")
    private User user;
    @OneToOne
    @JoinColumn(name = "fkProduct")
    private Product products;
    private Status status;


}
