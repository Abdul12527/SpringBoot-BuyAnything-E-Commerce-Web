package com.Arjunagi.BuyAnything.repository;

import com.Arjunagi.BuyAnything.models.order.FinalOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFinalOrderRepo extends JpaRepository<FinalOrder,Integer> {
}
