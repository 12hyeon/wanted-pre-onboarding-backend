package com.example.wantedpreonboardingbackend.company.service;

import com.example.wantedpreonboardingbackend.common.BaseResponse;
import com.example.wantedpreonboardingbackend.company.domain.Company;
import com.example.wantedpreonboardingbackend.company.dto.CompanyDto;
import com.example.wantedpreonboardingbackend.company.repository.CompanyRepository;
import com.example.wantedpreonboardingbackend.exception.CustomException;
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
        int companyNumber = 123;
        Company existingCompany = new Company("Existing Company", companyNumber);
        Mockito.when(companyRepository.findByNumber(companyNumber)).thenReturn(Optional.of(existingCompany));

        // When & Then
        CustomException exception = assertThrows(CustomException.class,
                () -> companyService.saveCompany("New Company", companyNumber)
        );
        assertEquals(ExceptionCode.DUPLICATE_COMPANY_NUMBER, exception.getExceptionCode());
    }

    @Test
    @DisplayName("중복되지 않은 번호 - 회사 저장")
    public void testSaveCompany2() {
        // Given
        int companyNumber = 456;
        Company newCompany = new Company("Existing Company", companyNumber);
        Mockito.when(companyRepository.findByNumber(companyNumber)).thenReturn(Optional.empty());
        Mockito.when(companyRepository.save(Mockito.any(Company.class))).thenReturn(newCompany); // company - id 설정

        // When
        BaseResponse<CompanyDto.CompanyResponse> response = companyService.saveCompany("New Company", companyNumber);

        // Then
        assertEquals(ExceptionCode.SAVE_COMPANY_OK.getCode(), response.getCode());
        assertNotNull(response.getResult().getCompanyId());
    }
}