package com.Arjunagi.BuyAnything.repository;

import com.Arjunagi.BuyAnything.models.product.Category;
import com.Arjunagi.BuyAnything.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findByCategory(Category name);
}
