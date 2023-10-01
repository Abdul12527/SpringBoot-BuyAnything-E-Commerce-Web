package com.Arjunagi.BuyAnything.services;

import com.Arjunagi.BuyAnything.models.product.Category;
import com.Arjunagi.BuyAnything.models.product.Product;
import com.Arjunagi.BuyAnything.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    IProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public List<Product> getAllByCategory(Category category) {
        return productRepo.findByCategory(category);
    }

    public String deleteById(Integer id) {
        productRepo.deleteById(id);
        return "deleted sucessfully";
    }
}
