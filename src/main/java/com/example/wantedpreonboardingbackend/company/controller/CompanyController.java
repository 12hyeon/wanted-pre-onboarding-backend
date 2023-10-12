package com.example.wantedpreonboardingbackend.company.controller;

import com.example.wantedpreonboardingbackend.response.BaseResponse;
import com.example.wantedpreonboardingbackend.response.CustomApiResponse;
import com.example.wantedpreonboardingbackend.company.dto.CompanyDto;
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

    @Operation(summary = "회사 등록", description = "회사 정보가 등록됩니다.", tags = { "Company Controller" })
    @CustomApiResponse.SaveApiResponse
    @PostMapping("/companies")
    public ResponseEntity<Object> saveCompany(@RequestParam @NotBlank String name, @RequestParam int number) {
        BaseResponse<CompanyDto.CompanyResponse> response = companyService.saveCompany(name, number);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
}
