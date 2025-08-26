package com.miempresa.servicecategory.service;

import com.miempresa.servicecategory.dto.CategoryRequest;
import com.miempresa.servicecategory.model.CategoryModel;
import com.miempresa.servicecategory.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryModel> findAllCategory(){
        return categoryRepository.findAll();
    }

    public CategoryModel findCategoryById(Long id){
        return categoryRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("There is not a Category with Id: " + id)
        );
    }

    public CategoryModel createCategory(CategoryRequest categoryRequest){
        CategoryModel categoryModel = CategoryModel.builder()
                .name(categoryRequest.getName())
                .image(categoryRequest.getImage())
                .build();

        return categoryRepository.save(categoryModel);
    }
}
