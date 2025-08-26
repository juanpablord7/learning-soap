package com.miempresa.servicecategory.model;

import jakarta.persistence.*;
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
@Entity
@Table(name = "category")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "The name can't be empty")
    @Size(min = 2)
    @Column(nullable = false, name = "name")
    private String name;

    @NotBlank(message = "The imagen can't be empty")
    @Size(min = 4)
    @Column(nullable = false, name = "image")
    private String image;
}
