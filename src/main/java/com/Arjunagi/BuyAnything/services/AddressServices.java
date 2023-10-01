package com.Arjunagi.BuyAnything.services;

import com.Arjunagi.BuyAnything.models.Address;
import com.Arjunagi.BuyAnything.repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServices {
    @Autowired
    IAddressRepo addressRepo;
    public void AddAddress(Address address) {
        addressRepo.save(address);
    }
    public List<Address> getAllAddress() {
        return addressRepo.findAll();
    }
}
