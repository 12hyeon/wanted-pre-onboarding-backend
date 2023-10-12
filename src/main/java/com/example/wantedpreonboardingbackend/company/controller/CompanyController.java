package com.example.wantedpreonboardingbackend.company.controller;

import com.example.wantedpreonboardingbackend.common.BaseResponse;
import com.example.wantedpreonboardingbackend.common.CustomApiResponse;
import com.example.wantedpreonboardingbackend.company.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "회사 등록 요청", description = "회사 정보가 추가됩니다.", tags = { "Company Controller" })
    @CustomApiResponse.SaveApiResponse
    @PostMapping("/companies")
    public ResponseEntity<Object> saveCompany(@RequestParam @NotBlank String name, @RequestParam int number) {
        BaseResponse response = companyService.saveCompany(name, number);
        return new ResponseEntity<>(response.getResult(), HttpStatus.valueOf(response.getStatus()));
    }
}
