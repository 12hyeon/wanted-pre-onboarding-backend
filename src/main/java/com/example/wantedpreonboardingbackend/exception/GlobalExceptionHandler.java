package com.example.wantedpreonboardingbackend.exception;

import com.example.wantedpreonboardingbackend.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getExceptionCode(), LocalDateTime.now().toString());
        return ResponseEntity.status(exception.getExceptionCode().getStatus()).body(errorResponse);
    }
}
