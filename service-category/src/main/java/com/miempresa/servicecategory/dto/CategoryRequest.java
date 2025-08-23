package com.miempresa.servicecategory.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    @NotBlank(message = "The name can't be empty")
    @Size(min = 2)
    private String name;

    @NotBlank(message = "The imagen can't be empty")
    @Size(min = 4)
    private String image;
}
