package com.example.wantedpreonboardingbackend.company.controller;

import com.example.wantedpreonboardingbackend.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/companies")
    public Object saveCompany(@RequestParam String name, @RequestParam long number) {
        return new ResponseEntity<>(companyService.saveCompany(name, number), HttpStatus.OK);
    }
}
