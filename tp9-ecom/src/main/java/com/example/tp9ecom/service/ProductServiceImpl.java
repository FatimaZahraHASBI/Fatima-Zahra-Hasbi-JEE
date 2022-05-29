package com.example.tp9ecom.service;

import com.example.tp9ecom.dtos.ProductDTO;
import com.example.tp9ecom.entities.Product;
import com.example.tp9ecom.mappers.CatalogMappers;
import com.example.tp9ecom.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CatalogMappers catalogMappers;
    @Override
    public ProductDTO save(ProductDTO productDTO){
        Product product=catalogMappers.fromProductDTO(productDTO);
        Product savedProduct = productRepository.save(product);
        return catalogMappers.fromProduct(savedProduct);
    }
    @Override
    public List<ProductDTO> listProducts(){
        List<Product> products=productRepository.findAll();
        List<ProductDTO> productDTOS=
                products.stream().map(p->catalogMappers.fromProduct(p))
                        .collect(Collectors.toList());
        return productDTOS;
    }

    @Override
    public ProductDTO getProduct(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found"));
        return catalogMappers.fromProduct(product);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product=catalogMappers.fromProductDTO(productDTO);
        Product saved = productRepository.save(product);
        return catalogMappers.fromProduct(saved);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

}
