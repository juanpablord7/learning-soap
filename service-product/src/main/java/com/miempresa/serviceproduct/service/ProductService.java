package com.miempresa.serviceproduct.service;

import com.miempresa.serviceproduct.client.CategorySoapClient;
import com.miempresa.serviceproduct.dto.ProductRequest;
import com.miempresa.serviceproduct.model.Product;
import com.miempresa.serviceproduct.repository.ProductRepository;
import com.miempresa.ws.GetCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategorySoapClient categorySoapClient;

    // Get All
    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    public Product findProduct(Long id){
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Don't Found any Product whit that Id: " + id));

    }

    public List<Product> findListProductById(List<Long> ids) {
        return productRepository.findAllByIdIn(ids);
    }

    public Product createProduct(ProductRequest request) {
        System.out.println("Request product to be saved: " + request.toString());

        Long categoryId;
        GetCategoryResponse response = categorySoapClient.getCategory(request.getCategory());
        if(response.getCategory() == null){
            categoryId = null;
        }else{
            System.out.println("Category " +response.getCategory());
            System.out.println("Category Id: " + response.getCategory().getId());
            System.out.println("Category Name: " + response.getCategory().getName());
            System.out.println("Category Image: " + response.getCategory().getImage());
            categoryId = (long) response.getCategory().getId();
        }

        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .category(categoryId)
                .image(request.getImage())
                .build();

        System.out.println("Product to save: " + product.toString());

        return productRepository.save(product);
    }
}
