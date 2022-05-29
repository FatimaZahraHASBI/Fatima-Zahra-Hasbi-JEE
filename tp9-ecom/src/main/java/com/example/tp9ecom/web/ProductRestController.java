package com.example.tp9ecom.web;

import com.example.tp9ecom.dtos.ProductDTO;
import com.example.tp9ecom.entities.Product;
import com.example.tp9ecom.repositories.ProductRepository;
import com.example.tp9ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin("*")
@RestController
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @GetMapping(path = "/products")
    public List<ProductDTO> productList(){
        return productService.listProducts();
    }

    @GetMapping(path = "/products/{id}")
    public Product getProduct(@PathVariable(name = "id") int id){
        return productRepository.findById(id).get();
    }

    @PostMapping("/products")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id){
        product.setId(id);
        return productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void daleteProduct(@PathVariable int id){
        productRepository.deleteById(id);
    }

}
