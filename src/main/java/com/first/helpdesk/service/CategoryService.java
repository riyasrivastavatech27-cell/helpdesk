package com.first.helpdesk.service;

import org.springframework.stereotype.Service;
import com.first.helpdesk.entity.Category;
import com.first.helpdesk.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }
    public Category getCategoryById(int id){
        return categoryRepository.findById(id).orElseThrow();
    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }
}
