package com.Arjunagi.BuyAnything.repository;

import com.Arjunagi.BuyAnything.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
}
