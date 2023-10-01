package com.Arjunagi.BuyAnything.models;

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
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "fkAddressId")
    private Address address;
    private Integer orderQuantity;
    @ManyToOne
    @JoinColumn(name = "fkUserId")
    private User user;
    @ManyToMany
    @JoinTable(name = "fk_product_order_table",joinColumns = @JoinColumn(name = "fk_order"),
            inverseJoinColumns = @JoinColumn(name = "fk_products"))
    private List<Product> products;
}
