package com.miempresa.serviceproduct.client;

import com.miempresa.serviceproduct.dto.client.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("category")
public interface CategoryClient {
    @GetMapping("/stores")
    Category getCategory(Long id);
}
