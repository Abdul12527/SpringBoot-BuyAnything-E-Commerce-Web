package com.Arjunagi.BuyAnything.controller;

import com.Arjunagi.BuyAnything.models.Address;
import com.Arjunagi.BuyAnything.services.AddressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressServices addressServices;

    @PostMapping("/address")
    public void AddAddress(@RequestBody Address address){
        addressServices.AddAddress(address);
    }
    @GetMapping("/addresses")
    public List<Address> getAllAddress(){
        return addressServices.getAllAddress();
    }

}
