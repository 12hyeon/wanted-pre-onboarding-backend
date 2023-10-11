package com.example.wantedpreonboardingbackend.posting.service;

import com.example.wantedpreonboardingbackend.common.BaseResponse;
import com.example.wantedpreonboardingbackend.company.repository.CompanyRepository;
import com.example.wantedpreonboardingbackend.exception.ExceptionCode;
import com.example.wantedpreonboardingbackend.posting.domain.Posting;
import com.example.wantedpreonboardingbackend.posting.dto.PostingDto;
import com.example.wantedpreonboardingbackend.posting.repository.PostingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PostingServiceImplTest {

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private PostingRepository postingRepository;

    @InjectMocks
    private PostingServiceImpl postingService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    @DisplayName("등록된 사업자등록번호 - 채용공고 저장")
    public void savePosting() {

        // Given
        int companyNumber = 123;

        PostingDto.PostingRequest request = new PostingDto.PostingRequest();
        request.setCompanyNumber(123);
        request.setTitle("XX기업 인턴 모집");
        request.setPosition("백엔드 개발자");
        request.setTechnology("Java");
        request.setDescription("신입 개발자를 모집합니다.");
        request.setReward(3000);
        request.setStartDate(LocalDateTime.now());
        request.setEndDate(request.getStartDate().plusDays(7));
        request.setCompanyNumber(companyNumber);

        Posting posting = Posting.builder().request(request).build();
        Mockito.when(companyRepository.existsByNumber(companyNumber)).thenReturn(Boolean.TRUE);
        Mockito.when(postingRepository.save(Mockito.any(Posting.class))).thenReturn(posting);

        // When
        BaseResponse response = postingService.savePosting(request);

        // Then
        assertEquals(ExceptionCode.SAVE_POSTING_OK.getMessage(), response.getMessage());
        assertEquals(ExceptionCode.SAVE_POSTING_OK.getCode(), response.getCode());
        assertEquals(response.getResult(), posting.getId());
    }
}

