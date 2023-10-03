package com.example.wantedpreonboardingbackend.company.repository;

import com.example.wantedpreonboardingbackend.company.domain.Company;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void saveCompanyAndFindById() {
        // Given
        String companyName = "테스트 회사";
        long companyNumber = 123;
        Company company = new Company(companyName, companyNumber);

        // When
        Company savedCompany = companyRepository.save(company);
        Long companyId = savedCompany.getId();
        Company foundCompany = companyRepository.findById(companyId).orElse(null);

        // Then
        assertEquals(companyName, Objects.requireNonNull(foundCompany).getName());
    }
}