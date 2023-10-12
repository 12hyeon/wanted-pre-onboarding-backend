package com.example.wantedpreonboardingbackend.posting.service;

import com.example.wantedpreonboardingbackend.response.BaseResponse;
import com.example.wantedpreonboardingbackend.posting.dto.PostingDto;

public interface PostingService {

    BaseResponse<PostingDto.PostingResponse> savePosting(Long companyId, PostingDto.PostingRequest request);
    BaseResponse<PostingDto.PostingResponse> updatePosting(Long postingId, PostingDto.PostingElementRequest request);
    BaseResponse<Void> deletePosting(Long postingId);
}
