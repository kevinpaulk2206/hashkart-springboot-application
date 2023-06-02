package com.hashkart.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private List<String> roles;


    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    // Constructors
    public User(String username, String password) {
    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = String.valueOf(id);
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = name;
    }

    // Add other getters and setters for additional fields

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public String getPassword() {
        return password;
    }
    public List<String> getRoles() {
        return roles;
    }

    public void setPassword(String encode) {
    }
}
