package com.example.wantedpreonboardingbackend.company.service;

import com.example.wantedpreonboardingbackend.response.BaseResponse;
import com.example.wantedpreonboardingbackend.company.dto.CompanyDto;

public interface CompanyService {

    BaseResponse<CompanyDto.CompanyResponse> saveCompany(String name, int number);
}
