package com.example.ecommerce.controller;


import com.example.ecommerce.controller.contract.UserControllerContract;
import com.example.ecommerce.dto.request.UserRequestDTO;
import com.example.ecommerce.dto.response.UserResponseDto;
import com.example.ecommerce.error.DataResult;
import com.example.ecommerce.error.Result;
import com.example.ecommerce.error.SuccessDataResult;
import com.example.ecommerce.error.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserControllerContract userControllerContract;


    @PostMapping
    public ResponseEntity<DataResult<UserResponseDto>> saveUser(@RequestBody UserRequestDTO user){
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessDataResult<>("Kayıt Başarılı", userControllerContract.saveUser(user)));
    }

    @GetMapping
    public ResponseEntity<DataResult<List<UserResponseDto>>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Listelendi", userControllerContract.getUsers()));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteUser(@PathVariable Long id, @RequestParam String username, @RequestParam String phoneNumber){
        userControllerContract.deleteUser(id, username, phoneNumber);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResult("Silindi"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<UserResponseDto>> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Güncellendi", userControllerContract.updateUser(id, userRequestDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<UserResponseDto>> getUserById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Listelendi", userControllerContract.getUserById(id)));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<DataResult<UserResponseDto>> getUserByUsername(@PathVariable String username){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Listelendi", userControllerContract.getUserByUsername(username)));
    }
}
