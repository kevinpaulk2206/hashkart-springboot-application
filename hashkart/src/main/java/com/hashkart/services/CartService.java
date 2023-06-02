package com.hashkart.services;

import com.hashkart.enums.PaymentMethod;
import com.hashkart.model.Cart;
import com.hashkart.model.Product;

import java.util.List;

public interface CartService {
    Cart getCartByUserId(String userId);
    void addToCart(String userId, Product product);
    void removeFromCart(String userId, String productId);
    void clearCart(String userId);
    List<Product> getCartItems(String userId);
    double calculateCartTotal(String userId);
    void applyCoupon(String userId, String couponCode);
    void removeCoupon(String userId);
}
