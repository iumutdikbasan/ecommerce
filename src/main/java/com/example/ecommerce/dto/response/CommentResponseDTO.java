package com.example.ecommerce.dto.response;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;

public record CommentResponseDTO(
        Long id,
        String commentText,
        Product product,
        User user
) {

}
