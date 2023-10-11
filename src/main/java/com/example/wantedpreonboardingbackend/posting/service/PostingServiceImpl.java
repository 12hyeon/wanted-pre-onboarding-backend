package com.example.wantedpreonboardingbackend.posting.service;

import com.example.wantedpreonboardingbackend.common.BaseResponse;
import com.example.wantedpreonboardingbackend.company.repository.CompanyRepository;
import com.example.wantedpreonboardingbackend.posting.domain.Posting;
import com.example.wantedpreonboardingbackend.posting.dto.PostingDto;
import com.example.wantedpreonboardingbackend.posting.repository.PostingRepository;
import com.example.wantedpreonboardingbackend.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostingServiceImpl implements PostingService {

    private final CompanyRepository companyRepository;
    private final PostingRepository postingRepository;


    @Override
    public BaseResponse savePosting(PostingDto.PostingRequest request) {
        if (!validateCompanyNumber(request.getCompanyNumber())) {
            return new BaseResponse(ExceptionCode.NOT_FOUND_COMPANY_NUMBER);
        }
        Posting posting = Posting.builder().request(request).build();
        Posting savedPosting = postingRepository.save(posting);
        return new BaseResponse(ExceptionCode.SAVE_POSTING_OK, savedPosting.getId());
    }

    public boolean validateCompanyNumber(int number) {
        return companyRepository.existsByNumber(number);
    }
}
