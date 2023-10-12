package com.example.wantedpreonboardingbackend.response;

import com.example.wantedpreonboardingbackend.config.ResponseType;
import com.example.wantedpreonboardingbackend.exception.ExceptionCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonPropertyOrder({"code", "message", "result"})
public class BaseResponse<T> extends ResponseType {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    public BaseResponse(ExceptionCode code) {
        super(code);
    }

    public BaseResponse(ExceptionCode code, T result) {
        super(code);
        this.result = result;
    }
}
