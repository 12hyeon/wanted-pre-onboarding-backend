package com.example.wantedpreonboardingbackend.company.service;

import com.example.wantedpreonboardingbackend.common.BaseResponse;
import com.example.wantedpreonboardingbackend.company.domain.Company;
import com.example.wantedpreonboardingbackend.company.dto.CompanyDto;
import com.example.wantedpreonboardingbackend.company.repository.CompanyRepository;
import com.example.wantedpreonboardingbackend.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public BaseResponse saveCompany(String name, int number) {
        Optional<Company> existingCompany = companyRepository.findByNumber(number);

        if (existingCompany.isPresent()) {
            Company duplicateCompany = existingCompany.get();
            return createDuplicateCompanyResponse(duplicateCompany);
        }

        Company newCompany = Company.builder()
                .number(number)
                .name(name)
                .build();

        Company savedCompany = companyRepository.save(newCompany);
        return createSaveCompanyResponse(savedCompany);
    }

    private BaseResponse createDuplicateCompanyResponse(Company company) {
        return new BaseResponse(
                ExceptionCode.DUPLICATE_COMPANY_NUMBER,
                new CompanyDto.CompanyResponse(company)
        );
    }

    private BaseResponse createSaveCompanyResponse(Company company) {
        return new BaseResponse(
                ExceptionCode.SAVE_COMPANY_OK,
                new CompanyDto.CompanyResponse(company)
        );
    }
}
