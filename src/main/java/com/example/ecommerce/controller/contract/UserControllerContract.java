package com.example.ecommerce.controller.contract;


import com.example.ecommerce.dto.request.UserRequestDTO;
import com.example.ecommerce.dto.response.UserResponseDto;

import java.util.List;

public interface UserControllerContract {
    UserResponseDto saveUser(UserRequestDTO userRequestDTO);
    List<UserResponseDto> getUsers();
    void deleteUser(Long id, String username, String phoneNumber);
    UserResponseDto updateUser(Long id, UserRequestDTO userRequestDTO);

    UserResponseDto getUserById(Long id);

    UserResponseDto getUserByUsername(String username);

}
