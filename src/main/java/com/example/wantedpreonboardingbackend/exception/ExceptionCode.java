package com.example.wantedpreonboardingbackend.exception;

import lombok.Getter;

import static com.example.wantedpreonboardingbackend.exception.HttpStatus.*;

@Getter
public enum ExceptionCode {

    // 회사
    DUPLICATE_COMPANY_NUMBER(DUPLICATED_VALUE, "C001", "이미 등록된 회사"),
    NOT_FOUND_COMPANY(NOT_FOUND, "C002", "등록되지 않은 회사"),

    SAVE_COMPANY_OK(CREATED, "C101", "회사 등록 성공"),

    // 채용공고
    NOT_FOUND_POSTING(NOT_FOUND, "P001", "등록되지 않은 채용공고"),

    SAVE_POSTING_OK(CREATED, "P101", "채용공고 등록 성공"),
    UPDATE_POSTING_OK(OK, "P102", "채용공고 수정 성공");

    private final int status;
    private final String code;
    private final String message;

    ExceptionCode(HttpStatus status, String code, String message) {
        this.status = status.getValue();
        this.code = code;
        this.message = message;
    }
}
