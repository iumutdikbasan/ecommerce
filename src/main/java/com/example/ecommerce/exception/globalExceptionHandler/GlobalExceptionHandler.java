package com.example.ecommerce.exception.globalExceptionHandler;

import com.example.ecommerce.error.Result;
import com.example.ecommerce.exception.exceptions.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MyException.class})
    public ResponseEntity<Result> notfound(MyException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Result(false,exception.getMessage()));
    }


}