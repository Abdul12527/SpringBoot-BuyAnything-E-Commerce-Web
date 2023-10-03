package com.Arjunagi.BuyAnything.repository;

import com.Arjunagi.BuyAnything.models.Address;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAddressRepo extends JpaRepository<Address,Integer> {
    List<Address> findByUserId(Integer userId);

    @Transactional
    @Modifying
    @Query("UPDATE Address a SET a.selected = :selected")
    void updateAll(@Param("selected") boolean selected);
}
