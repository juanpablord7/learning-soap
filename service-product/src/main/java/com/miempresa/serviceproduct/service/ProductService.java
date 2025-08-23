package com.miempresa.serviceproduct.service;

import com.miempresa.serviceproduct.dto.PaginatedResponse;
import com.miempresa.serviceproduct.dto.ProductPatchRequest;
import com.miempresa.serviceproduct.dto.ProductRequest;
import com.miempresa.serviceproduct.model.Product;
import com.miempresa.serviceproduct.repository.ProductRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

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

        Long category = 0L;
        if (request.getCategory() != null) {
            category = request.getCategory();
        }

        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .category(category)
                .image(request.getImage())
                .build();

        System.out.println("Product to save: " + product.toString());

        return productRepository.save(product);
    }
}
