package com.miempresa.serviceproduct.service;

import com.miempresa.serviceproduct.client.CategoryClient;
import com.miempresa.serviceproduct.dto.ProductRequest;
import com.miempresa.serviceproduct.dto.client.Category;
import com.miempresa.serviceproduct.model.Product;
import com.miempresa.serviceproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryClient categoryClient;

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
        Category category = categoryClient.getCategory(request.getCategory());
        if(category.getId() == -1L){
            categoryId = null;
        }else{
            categoryId = category.getId();
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
