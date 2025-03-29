package com.example.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repo.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Product getProductById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return repository.save(product);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    public Page<Product> getProductsByCategory(Long categoryId, Pageable pageable) {
        return repository.findByCategoryId(categoryId, pageable);
    }
}