package com.example.wantedpreonboardingbackend.company.service;

import com.example.wantedpreonboardingbackend.company.domain.Company;
import com.example.wantedpreonboardingbackend.company.dto.CompanyDto;
import com.example.wantedpreonboardingbackend.company.repository.CompanyRepository;
import com.example.wantedpreonboardingbackend.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public CompanyDto.CompanyResponse saveCompany(String name, int number) {
        return companyRepository.findByNumber(number)
                .map(existingCompany -> new CompanyDto.CompanyResponse(ExceptionCode.DUPLICATE_COMPANY_NUMBER, existingCompany))
                .orElseGet(() -> {
                    Company savedCompany = companyRepository.save(new Company(name, number));
                    return new CompanyDto.CompanyResponse(ExceptionCode.SAVE_COMPANY_OK, savedCompany);
                });
    }
}
