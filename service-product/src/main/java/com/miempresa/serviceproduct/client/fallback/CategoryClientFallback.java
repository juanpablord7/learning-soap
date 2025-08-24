package com.miempresa.serviceproduct.client.fallback;

import com.miempresa.serviceproduct.client.CategoryClient;
import com.miempresa.serviceproduct.dto.client.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryClientFallback implements CategoryClient {
    @Override
    public Category getCategory(Long id) {
        return Category.builder()
                .id(-1L)
                .build();
    }

}
