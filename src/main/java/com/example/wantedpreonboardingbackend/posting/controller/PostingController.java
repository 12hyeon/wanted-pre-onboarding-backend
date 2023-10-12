package com.example.wantedpreonboardingbackend.posting.controller;

import com.example.wantedpreonboardingbackend.common.BaseResponse;
import com.example.wantedpreonboardingbackend.common.CustomApiResponse;
import com.example.wantedpreonboardingbackend.posting.dto.PostingDto;
import com.example.wantedpreonboardingbackend.posting.service.PostingService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
@RestController
@RequiredArgsConstructor
public class PostingController {

    private final PostingService postingService;

    @Operation(summary = "채용공고 등록", description = "채용공고를 등록합니다.", tags = {"Posting Controller"})
    @CustomApiResponse.SaveApiResponse
    @PostMapping("/posting")
    public ResponseEntity<BaseResponse> savePosting(@RequestBody @Valid PostingDto.PostingRequest request) {
        return ResponseEntity.ok(postingService.savePosting(request));
    }
}
