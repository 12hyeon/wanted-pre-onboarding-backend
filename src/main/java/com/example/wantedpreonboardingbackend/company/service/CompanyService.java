package com.example.wantedpreonboardingbackend.company.service;

import com.example.wantedpreonboardingbackend.common.BaseResponse;

public interface CompanyService {

    BaseResponse saveCompany(String name, int number);
}
