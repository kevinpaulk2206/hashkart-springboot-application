package com.hashkart.repository;

import com.hashkart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(String id);
    List<Product> findByCategory(String category);
    List<Product> findByType(String type);

}