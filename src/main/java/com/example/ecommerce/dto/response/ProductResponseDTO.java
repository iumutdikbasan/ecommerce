package com.example.ecommerce.dto.response;

public record ProductResponseDTO(
        Long id,
        String productName,
        Integer price
) {
}
