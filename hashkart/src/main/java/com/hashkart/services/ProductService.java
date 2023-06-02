package com.hashkart.services;

import com.hashkart.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(String id);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByType(String type);
    List<Product> sortProductsByPrice(List<Product> products);
    List<Product> sortProductsByRating(List<Product> products);

    void addProduct(Product product);
}
