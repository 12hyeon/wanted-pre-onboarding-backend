package com.example.wantedpreonboardingbackend.company.service;

import com.example.wantedpreonboardingbackend.company.domain.Company;
import com.example.wantedpreonboardingbackend.company.repository.CompanyRepository;
import com.example.wantedpreonboardingbackend.company.response.CompanyResponse;
import com.example.wantedpreonboardingbackend.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public Object saveCompany(String name, long number) {
        Optional<Company> byNumber = companyRepository.findByNumber(number);
        if (byNumber.isPresent()) {
            return new CompanyResponse(ExceptionCode.DUPLICATE_COMPANY_NUMBER, byNumber.get().getId());
        }

        Company company = new Company(name, number);
        Long id = companyRepository.save(company).getId();
        return new CompanyResponse(ExceptionCode.SAVE_COMPANY_OK, id);
    }
}
