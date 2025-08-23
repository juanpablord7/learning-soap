package com.miempresa.servicecategory.controller;

import com.miempresa.servicecategory.dto.CategoryRequest;
import com.miempresa.servicecategory.model.Category;
import com.miempresa.servicecategory.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategory(){
        return ResponseEntity.ok(categoryService.findAllCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        Category category = categoryService.findCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> postCategory(@Valid @RequestBody CategoryRequest request){
        Category category = categoryService.createCategory(request);
        return ResponseEntity.status(201).body(category);
    }

}
