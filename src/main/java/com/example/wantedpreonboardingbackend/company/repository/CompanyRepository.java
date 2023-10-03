package com.example.wantedpreonboardingbackend.company.repository;

import com.example.wantedpreonboardingbackend.company.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company save(Company company);
    Optional<Company> findById(Long id);
    Optional<Company> findByNumber(long number);
}
