package com.example.wantedpreonboardingbackend.company.repository;

import com.example.wantedpreonboardingbackend.company.domain.Company;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    @DisplayName("회사 저장")
    public void saveCompanyAndFindById() {
        // Given
        String companyName = "테스트 회사";
        int companyNumber = 123;
        Company company = new Company(companyName, companyNumber);

        // When
        Company savedCompany = companyRepository.save(company);

        // Then
        assertEquals(companyName, savedCompany.getName());
        assertEquals(companyNumber, savedCompany.getNumber());
    }
}