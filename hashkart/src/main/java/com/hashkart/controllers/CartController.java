package com.hashkart.controllers;

import com.hashkart.model.Product;
import com.hashkart.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}/items")
    public ResponseEntity<Void> addToCart(@PathVariable String userId, @RequestBody Product product) {
        // Add the product to the user's cart
        cartService.addToCart(userId, product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/items/{productId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable String userId, @PathVariable String productId) {
        // Remove the product from the user's cart
        cartService.removeFromCart(userId, productId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/items")
    public ResponseEntity<Void> clearCart(@PathVariable String userId) {
        // Clear the user's cart
        cartService.clearCart(userId);
        return ResponseEntity.ok().build();
    }
}

