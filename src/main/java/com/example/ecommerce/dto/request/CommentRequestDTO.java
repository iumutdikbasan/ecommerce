package com.example.ecommerce.dto.request;

public record CommentRequestDTO(
        String commentText,
        Long productId,
        Long userId
) {
}
