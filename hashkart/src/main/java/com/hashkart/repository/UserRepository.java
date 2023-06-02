package com.hashkart.repository;

import com.hashkart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    User findById(String userId);
    void save(User user);
    void deleteById(String userId);
    List<User> findAll();

    boolean existsByUsername(String username);
}

