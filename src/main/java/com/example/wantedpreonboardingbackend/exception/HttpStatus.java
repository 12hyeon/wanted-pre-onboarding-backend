package com.example.wantedpreonboardingbackend.exception;

import lombok.Getter;

@Getter
public enum HttpStatus {
    OK(200),
    CREATED(201),
    INVALID_ACCESS(403),
    NOT_FOUND(404),
    DUPLICATED_VALUE(409);

    private final int value;

    HttpStatus(int value) {
        this.value = value;
    }
}