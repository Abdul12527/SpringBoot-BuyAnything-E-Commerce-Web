package com.Arjunagi.BuyAnything.controller;

import com.Arjunagi.BuyAnything.models.product.Category;
import com.Arjunagi.BuyAnything.models.product.Product;
import com.Arjunagi.BuyAnything.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductServices productServices;
    @PostMapping("/product")
    public void addProduct(Product product){
        productServices.addProduct(product);
    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productServices.getAllProducts();
    }
    @GetMapping("/products/category")
    public List<Product> getAllByCategory(@RequestParam Category category){
        return productServices.getAllByCategory(category);
    }
    @DeleteMapping("/product/id/{id}")
    public String deleteById(@PathVariable Integer id){
        return productServices.deleteById(id);
    }
}
