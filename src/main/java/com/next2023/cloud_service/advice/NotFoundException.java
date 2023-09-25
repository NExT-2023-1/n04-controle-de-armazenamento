package com.next2023.cloud_service.advice;


public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
