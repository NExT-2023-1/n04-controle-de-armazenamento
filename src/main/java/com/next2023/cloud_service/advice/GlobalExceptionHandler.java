package com.next2023.cloud_service.advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import com.next2023.cloud_service.dto.ExceptionDto;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class) // Certifique-se de importar ou definir NotFoundException corretamente
    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionDto(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ExceptionDto> handleResponseStatusException(ResponseStatusException e) {
        return ResponseEntity.status(e.getStatusCode())
                .body(new ExceptionDto(e.getStatusCode(), e.getReason()));
    }

    @ExceptionHandler(BadRequestException.class) // Certifique-se de importar ou definir BadRequestException corretamente
    public ResponseEntity<ExceptionDto> handleBadRequestException(BadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionDto(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionDto> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionDto(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDto> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionDto(HttpStatus.BAD_REQUEST, e.getMessage()));
    }
}
