package com.Arjunagi.BuyAnything.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;
    private String landMark;
    private String phoneNumber;
    private String zipcode;
    private String state;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fkUserId")
    private User user;
    private boolean selected;
}
