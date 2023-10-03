package com.example.wantedpreonboardingbackend.exception;

import lombok.Getter;

@Getter
public enum HttpStatus {
    SUCCESS(200),
    CREATED(201),
    INVALID_ACCESS(403),
    NOT_FOUND_VALUE(404),
    DUPLICATED_VALUE(409);

    private int value;

    HttpStatus(int value) {
        this.value = value;
    }
}
