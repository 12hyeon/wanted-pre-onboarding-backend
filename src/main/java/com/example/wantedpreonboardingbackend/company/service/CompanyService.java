package com.example.wantedpreonboardingbackend.company.service;

import com.example.wantedpreonboardingbackend.company.dto.CompanyDto;

public interface CompanyService {

    CompanyDto.CompanyResponse saveCompany(String name, int number);
}
