package com.example.ecommerce.error;

public class ErrorResult  extends Result{
    public ErrorResult(String message) {
        super(false, message);
    }

}
