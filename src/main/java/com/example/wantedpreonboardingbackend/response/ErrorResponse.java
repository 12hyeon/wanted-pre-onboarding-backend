package com.example.wantedpreonboardingbackend.response;

import com.example.wantedpreonboardingbackend.config.ResponseType;
import com.example.wantedpreonboardingbackend.exception.ExceptionCode;

import lombok.Getter;

@Getter
public class ErrorResponse extends ResponseType {

    private final String timestamp;

    public ErrorResponse(ExceptionCode exceptionCode, String timestamp) {
        super(exceptionCode);
        this.timestamp = timestamp;
    }
}
