package com.hashkart.services;

public interface PaymentService {
    void processPayment(String userId, double amount);
}
