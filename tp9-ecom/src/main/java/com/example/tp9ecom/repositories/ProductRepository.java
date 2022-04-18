package com.example.tp9ecom.repositories;

import com.example.tp9ecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, String> {
}
