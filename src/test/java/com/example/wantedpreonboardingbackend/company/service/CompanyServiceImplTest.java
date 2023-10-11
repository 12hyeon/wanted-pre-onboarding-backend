package com.example.wantedpreonboardingbackend.company.service;

import com.example.wantedpreonboardingbackend.company.domain.Company;
import com.example.wantedpreonboardingbackend.company.dto.CompanyDto;
import com.example.wantedpreonboardingbackend.company.repository.CompanyRepository;
import com.example.wantedpreonboardingbackend.exception.ExceptionCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompanyServiceImplTest {

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyServiceImpl companyService;

    @Test
    @DisplayName("중복된 번호 시 예외 발생 - 회사 저장")
    public void testSaveCompany() {
        // Given
        int companyNumber = 456;
        Mockito.when(companyRepository.findByNumber(companyNumber)).thenReturn(Optional.empty());
        Mockito.when(companyRepository.save(Mockito.any(Company.class))).thenReturn(new Company("New Company", companyNumber));

        // When
        CompanyDto.CompanyResponse response = companyService.saveCompany("New Company", companyNumber);

        // Then
        assertEquals(ExceptionCode.SAVE_COMPANY_OK.getCode(), response.getCode());
    }

    @Test
    @DisplayName("중복되지 않은 번호 - 회사 저장")
    public void testSaveCompany2() {
        // Given
        int companyNumber = 123;
        Company existingCompany = new Company("Existing Company", companyNumber);
        Mockito.when(companyRepository.findByNumber(companyNumber)).thenReturn(Optional.of(existingCompany));

        // When
        CompanyDto.CompanyResponse response = companyService.saveCompany("New Company", companyNumber);

        // Then
        assertEquals(ExceptionCode.DUPLICATE_COMPANY_NUMBER.getCode(), response.getCode());
    }
}