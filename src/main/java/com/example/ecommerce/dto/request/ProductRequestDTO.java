package com.example.ecommerce.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ProductRequestDTO(
        @NotBlank String productName,
        Integer price
) {
}
