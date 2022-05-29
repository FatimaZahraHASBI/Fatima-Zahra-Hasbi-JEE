package com.example.tp9ecom.dtos;

import com.example.tp9ecom.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor  @AllArgsConstructor
public class ProductDTO {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private CategoryDTO categoryDTO;
}
