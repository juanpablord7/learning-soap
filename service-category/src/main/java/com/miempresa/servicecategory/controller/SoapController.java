package com.miempresa.servicecategory.controller;

import com.miempresa.servicecategory.model.CategoryModel;
import com.miempresa.servicecategory.service.CategoryService;
import com.miempresa.ws.Category;
import com.miempresa.ws.GetCategoryRequest;
import com.miempresa.ws.GetCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SoapController {
    @Autowired
    CategoryService categoryService;

    private static final String NAMESPACE_URI = "http://miempresa.com/ws";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCategoryRequest")
    @ResponsePayload
    public GetCategoryResponse getCountry(@RequestPayload GetCategoryRequest request) {
        GetCategoryResponse response = new GetCategoryResponse();

        //Find the category
        CategoryModel categoryModel = categoryService.findCategoryById((long) request.getId());

        //Map the category
        Category category = new Category();

        category.setId((int) categoryModel.getId());
        category.setName(categoryModel.getName());
        category.setImage(categoryModel.getImage());

        //Prepare the response
        response.setCategory(category);

        return response;
    }
}
