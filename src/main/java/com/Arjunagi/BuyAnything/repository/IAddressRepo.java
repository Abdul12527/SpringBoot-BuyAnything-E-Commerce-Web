package com.Arjunagi.BuyAnything.repository;

import com.Arjunagi.BuyAnything.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepo extends JpaRepository<Address,Integer> {
}
