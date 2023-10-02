package com.Arjunagi.BuyAnything.repository;

import com.Arjunagi.BuyAnything.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAddressRepo extends JpaRepository<Address,Integer> {
    List<Address> findByUserId(Integer userId);
}
