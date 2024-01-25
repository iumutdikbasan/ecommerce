package com.example.ecommerce.error;

public class SuccessDataResult <T>  extends DataResult<T>{
    public SuccessDataResult(String message, T data) {
        super(true, message, data);
    }


}