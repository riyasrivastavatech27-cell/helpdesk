package com.first.helpdesk.controller;
import  java.util.List;
import com.first.helpdesk.service.CategoryService;
import com.first.helpdesk.entity.Category;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @PostMapping
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }
    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @DeleteMapping("/{id}")
    public  void deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
    }
}
