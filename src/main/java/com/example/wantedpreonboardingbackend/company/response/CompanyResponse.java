package com.example.wantedpreonboardingbackend.company.response;

import com.example.wantedpreonboardingbackend.config.ResponseType;
import com.example.wantedpreonboardingbackend.exception.ExceptionCode;

public class CompanyResponse extends ResponseType {
    private Long companyId;

    public CompanyResponse(ExceptionCode exceptionCode, Long companyId) {
        super(exceptionCode);
        this.companyId = companyId;
    }
}
