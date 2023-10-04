package com.Arjunagi.BuyAnything.controller;

import com.Arjunagi.BuyAnything.models.Address;
import com.Arjunagi.BuyAnything.models.User;
import com.Arjunagi.BuyAnything.services.AddressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressServices addressServices;

    @PostMapping("/address/user/id/{id}")
    public void AddAddress(@RequestBody Address address,@PathVariable Integer id){
        addressServices.AddAddress(address,id);
    }
    @GetMapping("/addresses")
    public List<Address> getAllAddress(){
        return addressServices.getAllAddress();
    }
    @GetMapping("/addresses/id/{userId}")
    public List<Address> getAllForUser(@PathVariable Integer userId){
        return addressServices.getAllForUser(userId);
    }

}
