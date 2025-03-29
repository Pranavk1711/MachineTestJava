package com.example.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	Page<Product> findByCategoryId(Long categoryId, Pageable pageable);

}
