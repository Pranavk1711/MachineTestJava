package com.example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.repo.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository repository;
	
	public CategoryService(CategoryRepository repository) {
		this.repository = repository;
	}
	
	public Page<Category> getAllCategories(Pageable pageable){
		return repository.findAll(pageable);	
	}
	
	public Category getCategoryById(Long id) {
		return repository.findById(id).orElseThrow();
	}
	
	public Category createCategory(Category category) {
		return repository.save(category);
	}
	
	public Category updateCategory(Long id,Category category) {
		category.setId(id);
		return repository.save(category);
	}
	
	public void deleteCategory(Long id) {
		repository.deleteById(id);
	}
}
