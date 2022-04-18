package com.example.tp9ecom.dtos;

import com.example.tp9ecom.entities.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;

}
