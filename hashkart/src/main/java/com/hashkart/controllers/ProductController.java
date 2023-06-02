package com.hashkart.controllers;

import com.hashkart.model.Product;
import com.hashkart.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        List<Product> products = productService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Product>> getProductsByType(@PathVariable String type) {
        List<Product> products = productService.getProductsByType(type);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/sort/price")
    public ResponseEntity<List<Product>> sortProductsByPrice() {
        List<Product> products = productService.getAllProducts();
        List<Product> sortedProducts = productService.sortProductsByPrice(products);
        return ResponseEntity.ok(sortedProducts);
    }

    @GetMapping("/sort/rating")
    public ResponseEntity<List<Product>> sortProductsByRating() {
        List<Product> products = productService.getAllProducts();
        List<Product> sortedProducts = productService.sortProductsByRating(products);
        return ResponseEntity.ok(sortedProducts);
    }

}

