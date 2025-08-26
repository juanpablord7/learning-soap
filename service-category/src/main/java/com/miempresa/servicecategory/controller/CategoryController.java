package com.miempresa.servicecategory.controller;

import com.miempresa.servicecategory.dto.CategoryRequest;
import com.miempresa.servicecategory.model.CategoryModel;
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
    public ResponseEntity<List<CategoryModel>> getAllCategory(){
        return ResponseEntity.ok(categoryService.findAllCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id){
        CategoryModel categoryModel = categoryService.findCategoryById(id);
        return ResponseEntity.ok(categoryModel);
    }

    @PostMapping
    public ResponseEntity<CategoryModel> postCategory(@Valid @RequestBody CategoryRequest request){
        CategoryModel categoryModel = categoryService.createCategory(request);
        return ResponseEntity.status(201).body(categoryModel);
    }

}
