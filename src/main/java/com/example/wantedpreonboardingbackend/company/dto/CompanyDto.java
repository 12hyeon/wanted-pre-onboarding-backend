package com.example.wantedpreonboardingbackend.company.dto;

import com.example.wantedpreonboardingbackend.company.domain.Company;
import com.example.wantedpreonboardingbackend.config.ResponseType;
import com.example.wantedpreonboardingbackend.exception.ExceptionCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CompanyDto {

    @Getter
    @NoArgsConstructor
    public static class CompanyRequest {
        private String name;
        private int number;
    }

    @Getter
    public static class CompanyResponse extends ResponseType {
        private Long companyId;
        private String name;
        private int number;

        public CompanyResponse(ExceptionCode code, Company company) {
            super(code);
            companyId = company.getId();
            name = company.getName();
            number = company.getNumber();
        }
    }
}
