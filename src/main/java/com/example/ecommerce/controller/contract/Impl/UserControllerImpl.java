package com.example.ecommerce.controller.contract.Impl;

import com.example.ecommerce.controller.contract.UserControllerContract;
import com.example.ecommerce.dto.request.UserRequestDTO;
import com.example.ecommerce.dto.response.UserResponseDto;
import com.example.ecommerce.exception.exceptions.MyException;
import com.example.ecommerce.mapper.UserMapper;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.CommentService;
import com.example.ecommerce.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserControllerImpl implements UserControllerContract {

    private final UserMapper userMapper;
    private final UserService userService;
    private final CommentService commentService;

    @Override
    public UserResponseDto saveUser(UserRequestDTO userRequestDTO) {
        User user = userService.save(userMapper.toUser(userRequestDTO));
        UserResponseDto userResponseDto = userMapper.toResponseDTO(user);
        return userResponseDto;
    }

    @Override
    public List<UserResponseDto> getUsers() {
        List<UserResponseDto> userResponseDTOS = userService.findAll().stream().map(userMapper::toResponseDTO).collect(java.util.stream.Collectors.toList());
        return userResponseDTOS;
    }

    @Transactional
    @Override
    public void deleteUser(Long id, String username, String phoneNumber) {
        User user = userService.findById(id).orElseThrow(() -> new MyException("Silme Yapılamadı"));

        if (!user.getUsername().equals(username) || !user.getPhoneNumber().equals(phoneNumber)) {
            throw new MyException("Kullanıcı adı ile Telefon bilgileri uyuşmamaktadır");
        } else
            deleteCommentsByUser(user);
        userService.delete(user);
    }
        private void deleteCommentsByUser(User user){

            commentService.deleteCommentsByUser(user);
        }


    @Override
    public UserResponseDto updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = userService.findById(id).orElseThrow(() -> new MyException("Güncelleme Yapılamadı"));
        user.setUsername(userRequestDTO.username());
        user.setPhoneNumber(userRequestDTO.phoneNumber());
        user.setEmail(userRequestDTO.email());
        user.setUserType(userRequestDTO.userType());
        user.setPassword(userRequestDTO.password());
        UserResponseDto userResponseDTO = userMapper.toResponseDTO(userService.save(user));

        return userResponseDTO;
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userService.findById(id).orElseThrow(() -> new MyException("Bulunamadı"));
        UserResponseDto userResponseDTO = userMapper.toResponseDTO(user);

        return userResponseDTO;
    }

    @Override
    public UserResponseDto getUserByUsername(String username) {
        User user = userService.findByUsername(username);
        UserResponseDto userResponseDTO = userMapper.toResponseDTO(user);

        return userResponseDTO;
    }
}
