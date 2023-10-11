package com.example.wantedpreonboardingbackend.company.controller;

import com.example.wantedpreonboardingbackend.company.dto.CompanyDto;
import com.example.wantedpreonboardingbackend.company.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "회사 등록 요청", description = "회사 정보가 추가됩니다.", tags = { "Company Controller" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = CompanyDto.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND")
    })
    @PostMapping("/companies")
    public ResponseEntity<CompanyDto.CompanyResponse> saveCompany(@RequestParam @NotBlank String name, @RequestParam @NotNull int number) {
        return ResponseEntity.ok(companyService.saveCompany(name, number));
    }
}
