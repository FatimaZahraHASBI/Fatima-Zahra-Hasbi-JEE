package com.example.tp5jpa.repositories;

import com.example.tp5jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String userName);
}
