package com.example.wantedpreonboardingbackend.posting.controller;

import com.example.wantedpreonboardingbackend.response.BaseResponse;
import com.example.wantedpreonboardingbackend.response.CustomApiResponse;
import com.example.wantedpreonboardingbackend.posting.dto.PostingDto;
import com.example.wantedpreonboardingbackend.posting.service.PostingService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
@RestController
@RequiredArgsConstructor
public class PostingController {

    private final PostingService postingService;

    @Operation(summary = "채용공고 등록", description = "채용공고를 등록합니다. (title, position 필수)", tags = {"Posting Controller"})
    @CustomApiResponse.SaveApiResponse
    @PostMapping("/posting")
    public ResponseEntity<Object> savePosting(@RequestParam Long companyId, @RequestBody @Valid PostingDto.PostingRequest request) {
        BaseResponse<PostingDto.PostingResponse> response = postingService.savePosting(companyId, request);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @Operation(summary = "채용공고 수정", description = "채용공고를 수정합니다. (position 필수)", tags = {"Posting Controller"})
    @CustomApiResponse.BaseApiResponse
    @PutMapping("/posting")
    public ResponseEntity<Object> updatePosting(@RequestParam Long postingId, @RequestBody @Valid PostingDto.PostingElementRequest request) {
        BaseResponse<PostingDto.PostingResponse> response = postingService.updatePosting(postingId, request);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
}
