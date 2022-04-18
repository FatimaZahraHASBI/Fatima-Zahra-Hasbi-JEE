package com.example.tp9ecom.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity @Data
@NoArgsConstructor  @AllArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private double quantity;
    @ManyToOne
    private Category category;
}
