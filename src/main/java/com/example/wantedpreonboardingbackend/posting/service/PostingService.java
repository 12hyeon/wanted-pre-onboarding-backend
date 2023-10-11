package com.example.wantedpreonboardingbackend.posting.service;

import com.example.wantedpreonboardingbackend.common.BaseResponse;
import com.example.wantedpreonboardingbackend.posting.dto.PostingDto;

public interface PostingService {

    BaseResponse savePosting(PostingDto.PostingRequest request);
}
