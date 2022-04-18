package com.example.tp9ecom.service;

import com.example.tp9ecom.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO save(ProductDTO productDTO);

    List<ProductDTO> listProducts();

    ProductDTO getProduct(String id);

    ProductDTO updateProduct(ProductDTO productDTO);

    void  deleteProduct(String id);
}
