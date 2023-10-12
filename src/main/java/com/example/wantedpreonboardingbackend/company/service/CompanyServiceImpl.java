package com.example.wantedpreonboardingbackend.company.service;

import com.example.wantedpreonboardingbackend.exception.CustomException;
import com.example.wantedpreonboardingbackend.response.BaseResponse;
import com.example.wantedpreonboardingbackend.company.domain.Company;
import com.example.wantedpreonboardingbackend.company.dto.CompanyDto;
import com.example.wantedpreonboardingbackend.company.repository.CompanyRepository;
import com.example.wantedpreonboardingbackend.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    @Transactional
    public BaseResponse<CompanyDto.CompanyResponse> saveCompany(String name, int number) {
        Optional<Company> existingCompany = companyRepository.findByNumber(number);

        if (existingCompany.isPresent()) {
            throw new CustomException(ExceptionCode.DUPLICATE_COMPANY_NUMBER);
        }

        Company newCompany = Company.builder()
                .number(number)
                .name(name)
                .build();

        Company savedCompany = companyRepository.save(newCompany);
        return new BaseResponse<>(
                ExceptionCode.SAVE_COMPANY_OK,
                new CompanyDto.CompanyResponse(savedCompany)
        );
    }
}
