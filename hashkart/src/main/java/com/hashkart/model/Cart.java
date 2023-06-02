package com.hashkart.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    private String userId;
    @OneToMany (cascade = CascadeType.ALL)
    private List<Product> items;
    @OneToOne
    private Coupon coupon;

    public Cart() {
    }

    public Cart(String userId) {
        this.userId = userId;
        this.items = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public void addProduct(Product product) {
        items.add(product);
    }

    public void removeProduct(String productId) {
        items.removeIf(item -> item.getId().equals(productId));
    }

    public void clear() {
        items.clear();
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product item : items) {
            total += item.getPrice();
        }
        if (coupon != null) {
            double discount = total * (coupon.getDiscount() / 100);
            total -= discount;
        }
        return total;
    }


}
