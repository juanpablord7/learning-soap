package com.miempresa.serviceproduct.client;

import com.miempresa.serviceproduct.client.fallback.CategoryClientFallback;
import com.miempresa.serviceproduct.dto.client.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-category", path = "/category", fallback = CategoryClientFallback.class)
public interface CategoryClient {
    @GetMapping("/{id}")
    Category getCategory(@PathVariable("id") Long id);
}

