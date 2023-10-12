package com.example.wantedpreonboardingbackend.config;

import com.example.wantedpreonboardingbackend.exception.ExceptionCode;
import lombok.Getter;

@Getter
public class ResponseType {
    private final int status;
    private final String code;
    private final String message;

    public ResponseType(ExceptionCode exceptionCode) {
        this.status = exceptionCode.getStatus();
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
    }
}
