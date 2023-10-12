package com.example.wantedpreonboardingbackend.company.dto;

import com.example.wantedpreonboardingbackend.company.domain.Company;
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
    public static class CompanyResponse {
        private Long companyId;
        private String name;
        private int number;

        public CompanyResponse(Company company) {
            companyId = company.getId();
            name = company.getName();
            number = company.getNumber();
        }
    }
}
