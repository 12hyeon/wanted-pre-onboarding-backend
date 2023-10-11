package com.example.wantedpreonboardingbackend.posting.service;

import com.example.wantedpreonboardingbackend.common.BaseResponse;
import com.example.wantedpreonboardingbackend.company.domain.Company;
import com.example.wantedpreonboardingbackend.company.repository.CompanyRepository;
import com.example.wantedpreonboardingbackend.posting.domain.Posting;
import com.example.wantedpreonboardingbackend.posting.dto.PostingDto;
import com.example.wantedpreonboardingbackend.posting.repository.PostingRepository;
import com.example.wantedpreonboardingbackend.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostingServiceImpl implements PostingService {

    private final CompanyRepository companyRepository;
    private final PostingRepository postingRepository;


    @Override
    public BaseResponse savePosting(PostingDto.PostingRequest request) {
        Optional<Company> company = getCompanyByNumber(request.getCompanyNumber());
        if (company.isEmpty()) {
            return new BaseResponse(ExceptionCode.NOT_FOUND_COMPANY_NUMBER);
        }
        Posting posting = Posting.builder().request(request).build();
        posting.addPosting(company.get());

        Posting savedPosting = postingRepository.save(posting);
        return new BaseResponse(ExceptionCode.SAVE_POSTING_OK, savedPosting.getId());
    }

    public Optional<Company> getCompanyByNumber(int number) {
        return companyRepository.findByNumber(number);
    }
}
