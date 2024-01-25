package com.example.ecommerce.dto.request;

import com.example.ecommerce.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank String username,
        @NotBlank String password,
        @NotBlank String phoneNumber,
        @Email String email,
        UserType userType
) {
}
