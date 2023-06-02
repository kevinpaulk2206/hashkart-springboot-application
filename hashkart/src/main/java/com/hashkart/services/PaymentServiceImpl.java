package com.hashkart.services;

import com.hashkart.model.Cart;
import com.hashkart.model.Payment;
import com.hashkart.repository.CartRepository;
import com.hashkart.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final CartRepository cartRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, CartRepository cartRepository) {
        this.paymentRepository = paymentRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void processPayment(String userId, double amount) {
        // Retrieve the cart for the user
        Cart cart = cartRepository.findByUserId(userId);

        // Calculate the cart total
        double cartTotal = cart != null ? cart.calculateTotal() : 0.0;

        // Check if the amount to be paid matches the cart total
        if (amount != cartTotal) {
            throw new IllegalArgumentException("Invalid payment amount");
        }

        // Perform payment processing logic here, such as connecting to a payment gateway or service
        boolean paymentSuccessful = processPaymentWithGateway(userId, amount);

        // Create a new payment record
        Payment payment = new Payment(userId, amount, paymentSuccessful);

        // Save the payment details to the database
        paymentRepository.save(payment);


        if (paymentSuccessful) {
            handleSuccessfulPayment(userId);
        } else {
            handleFailedPayment(userId);
        }
    }

    private boolean processPaymentWithGateway(String userId, double amount) {

        return true;
    }

    private void handleSuccessfulPayment(String userId) {
        // Perform operations for a successful payment
        System.out.println("Payment successful. User ID: " + userId);
    }

    private void handleFailedPayment(String userId) {
        // Perform operations for a failed payment
        System.out.println("Payment failed. User ID: " + userId);
    }
}

