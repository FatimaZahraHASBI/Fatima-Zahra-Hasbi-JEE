package com.example.tp9ecom;

import com.example.tp9ecom.entities.Category;
import com.example.tp9ecom.entities.Product;
import com.example.tp9ecom.repositories.CategoryRepository;
import com.example.tp9ecom.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp9EcomApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp9EcomApplication.class, args);
    }
    @Bean
    public CommandLineRunner start(ProductRepository productRepository, CategoryRepository categoryRepository){
        return args -> {
            Stream.of("Computers", "Printers", "Smartphone").forEach(name->{
                Category category=new Category();
                category.setName(name);
                categoryRepository.save(category);
            });
            categoryRepository.findAll().forEach(cat->{
                for (int i = 1; i <= 5; i++) {
                    Product product=new Product();
                    product.setPrice((int) (100+Math.random()*9000));
                    product.setQuantity((int) (1+Math.random()*50));
                    product.setName(cat.getName()+'-'+i);
                    product.setCategory(cat);
                    productRepository.save(product);
                }
            });
        };
    }

}
