package com.hashkart.services;

import com.hashkart.model.Cart;
import com.hashkart.model.Coupon;
import com.hashkart.model.Product;
import com.hashkart.repository.CartRepository;
import com.hashkart.repository.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CouponRepository couponRepository;

    public CartServiceImpl(CartRepository cartRepository, CouponRepository couponRepository) {
        this.cartRepository = cartRepository;
        this.couponRepository = couponRepository;
    }

    @Override
    public Cart getCartByUserId(String userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public void addToCart(String userId, Product product) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            cart = new Cart(userId);
        }
        cart.addProduct(product);
        cartRepository.save(cart);
    }

    @Override
    public void removeFromCart(String userId, String productId) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart != null) {
            cart.removeProduct(productId);
            cartRepository.save(cart);
        }
    }

    @Override
    public void clearCart(String userId) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart != null) {
            cart.clear();
            cartRepository.save(cart);
        }
    }

    @Override
    public List<Product> getCartItems(String userId) {
        Cart cart = cartRepository.findByUserId(userId);
        return cart != null ? cart.getItems() : Collections.emptyList();
    }

    @Override
    public double calculateCartTotal(String userId) {
        Cart cart = cartRepository.findByUserId(userId);
        return cart != null ? cart.calculateTotal() : 0.0;
    }

    @Override
    public void applyCoupon(String userId, String couponCode) {
        Cart cart = cartRepository.findByUserId(userId);
        Coupon coupon = couponRepository.findByCode(couponCode);
        if (cart != null && coupon != null) {
            cart.setCoupon(coupon);
            cartRepository.save(cart);
        }
    }

    @Override
    public void removeCoupon(String userId) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart != null) {
            cart.setCoupon(null);
            cartRepository.save(cart);
        }
    }
}

