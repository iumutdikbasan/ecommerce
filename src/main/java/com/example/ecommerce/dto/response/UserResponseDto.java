package com.example.ecommerce.dto.response;

import com.example.ecommerce.enums.UserType;

public record UserResponseDto(
        Long id,
        String username,
        String phoneNumber,
        String email,
        UserType userType
) {
}
