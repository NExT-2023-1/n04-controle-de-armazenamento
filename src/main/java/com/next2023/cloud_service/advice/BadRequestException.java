package com.next2023.cloud_service.advice;


public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}