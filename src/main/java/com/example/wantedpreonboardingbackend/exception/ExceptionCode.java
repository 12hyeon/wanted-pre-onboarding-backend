package com.example.wantedpreonboardingbackend.exception;

import lombok.Getter;

import static com.example.wantedpreonboardingbackend.exception.HttpStatus.CREATED;
import static com.example.wantedpreonboardingbackend.exception.HttpStatus.DUPLICATED_VALUE;

@Getter
public enum ExceptionCode {

    SAVE_COMPANY_OK(CREATED, "C001", "회사 저장 성공"),
    DUPLICATE_COMPANY_NUMBER(DUPLICATED_VALUE, "C002", "이미 저장된 회사");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ExceptionCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
