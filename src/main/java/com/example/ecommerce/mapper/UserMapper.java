package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.request.UserRequestDTO;
import com.example.ecommerce.dto.response.UserResponseDto;
import com.example.ecommerce.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequestDTO userRequestDTO);
    UserRequestDTO toRequestDTO(User user);

    User user(UserResponseDto userResponseDto);
    UserResponseDto toResponseDTO(User user);
}
