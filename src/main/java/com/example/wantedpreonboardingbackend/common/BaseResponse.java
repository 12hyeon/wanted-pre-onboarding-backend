package com.example.wantedpreonboardingbackend.common;

import com.example.wantedpreonboardingbackend.config.ResponseType;
import com.example.wantedpreonboardingbackend.exception.ExceptionCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonPropertyOrder({"code", "message", "result"})
public class BaseResponse extends ResponseType {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object result;

    public BaseResponse(ExceptionCode code) {
        super(code);
    }

    public BaseResponse(ExceptionCode code, Object result) {
        super(code);
        this.result = result;
    }
}
