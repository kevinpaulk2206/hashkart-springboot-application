package com.hashkart.model;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private double amount;
    private boolean successful;

    // Constructors
    public Payment() {
    }

    public Payment(String userId, double amount, boolean successful) {
        this.userId = userId;
        this.amount = amount;
        this.successful = successful;
    }

    public Payment(double amount) {
        this.amount = amount;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
