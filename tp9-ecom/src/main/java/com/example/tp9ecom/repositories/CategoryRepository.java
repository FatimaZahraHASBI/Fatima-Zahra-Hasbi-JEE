package com.example.tp9ecom.repositories;

import com.example.tp9ecom.entities.Category;
import com.example.tp9ecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
