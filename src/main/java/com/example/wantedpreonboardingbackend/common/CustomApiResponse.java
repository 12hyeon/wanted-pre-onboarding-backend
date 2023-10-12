package com.example.wantedpreonboardingbackend.common;

import com.example.wantedpreonboardingbackend.exception.CustomException;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public @interface CustomApiResponse {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "CREATED", content = @Content(schema = @Schema(implementation = BaseResponse.class))),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND", content = @Content(schema = @Schema(implementation = CustomException.class))),
            @ApiResponse(responseCode = "409", description = "DUPLICATED_VALUE", content = @Content(schema = @Schema(implementation = CustomException.class)))
    })
    @interface SaveApiResponse {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = BaseResponse.class))),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND", content = @Content(schema = @Schema(implementation = CustomException.class))),
            @ApiResponse(responseCode = "409", description = "DUPLICATED_VALUE", content = @Content(schema = @Schema(implementation = CustomException.class)))
    })
    @interface BaseApiResponse {}
}
