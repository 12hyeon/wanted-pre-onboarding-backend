package com.example.wantedpreonboardingbackend.posting.service;

import com.example.wantedpreonboardingbackend.exception.CustomException;
import com.example.wantedpreonboardingbackend.response.BaseResponse;
import com.example.wantedpreonboardingbackend.company.domain.Company;
import com.example.wantedpreonboardingbackend.company.repository.CompanyRepository;
import com.example.wantedpreonboardingbackend.posting.domain.Posting;
import com.example.wantedpreonboardingbackend.posting.dto.PostingDto;
import com.example.wantedpreonboardingbackend.posting.repository.PostingRepository;
import com.example.wantedpreonboardingbackend.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostingServiceImpl implements PostingService {

    private final CompanyRepository companyRepository;
    private final PostingRepository postingRepository;

    @Override
    @Transactional
    public BaseResponse<PostingDto.PostingResponse> savePosting(Long companyId, PostingDto.PostingRequest request) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new CustomException(ExceptionCode.NOT_FOUND_COMPANY));

        Posting posting = Posting.builder().request(request).build();
        posting.addPosting(company);
        Posting savedPosting = postingRepository.save(posting);

        return new BaseResponse<>(ExceptionCode.SAVE_POSTING_OK, new PostingDto.PostingResponse(posting));
    }

    @Override
    @Transactional
    public BaseResponse<PostingDto.PostingResponse> updatePosting(Long postingId, PostingDto.PostingElementRequest request) {
        Posting posting = postingRepository.findById(postingId)
                .orElseThrow(() -> new CustomException(ExceptionCode.NOT_FOUND_POSTING));

        posting.update(request);

        return new BaseResponse<>(ExceptionCode.UPDATE_POSTING_OK, new PostingDto.PostingResponse(posting));
    }
}
