package com.example.wantedpreonboardingbackend.posting.service;

import com.example.wantedpreonboardingbackend.common.BaseResponse;
import com.example.wantedpreonboardingbackend.company.domain.Company;
import com.example.wantedpreonboardingbackend.company.repository.CompanyRepository;
import com.example.wantedpreonboardingbackend.exception.CustomException;
import com.example.wantedpreonboardingbackend.exception.ExceptionCode;
import com.example.wantedpreonboardingbackend.posting.domain.Posting;
import com.example.wantedpreonboardingbackend.posting.dto.PostingDto;
import com.example.wantedpreonboardingbackend.posting.repository.PostingRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

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

    @Test
    @DisplayName("등록o 사업자등록번호 - 채용공고 저장")
    public void savePosting() {

        // Given
        Long companyId = 1L;
        Company company = new Company("existing Company", 123);
        Mockito.when(companyRepository.findById(companyId)).thenReturn(Optional.of(company));

        PostingDto.PostingRequest request = new PostingDto.PostingRequest();
        request.setTitle("XX기업 인턴 모집");
        request.setPosition("백엔드 개발자");
        request.setTechnology("Java");
        request.setDescription("신입 개발자를 모집합니다.");
        request.setReward(3000);
        request.setEndDate(LocalDateTime.now().plusDays(7));


        Posting posting = Posting.builder()
                .request(request)
                .company(company)
                .build();

        Mockito.when(companyRepository.existsById(companyId)).thenReturn(Boolean.TRUE);
        Mockito.when(postingRepository.save(Mockito.any(Posting.class))).thenReturn(posting);

        // When
        BaseResponse<PostingDto.PostingResponse> response = postingService.savePosting(companyId, request);

        // Then
        assertEquals(ExceptionCode.SAVE_POSTING_OK.getMessage(), response.getMessage());
        assertEquals(ExceptionCode.SAVE_POSTING_OK.getCode(), response.getCode());
    }

    @Test
    @DisplayName("등록x 사업자등록번호 - 채용공고 저장")
    public void savePosting2() {

        // Given
        Long companyId = 1L;
        Mockito.when(companyRepository.findById(companyId)).thenReturn(Optional.empty());

        PostingDto.PostingRequest request = new PostingDto.PostingRequest();
        request.setTitle("XX기업 인턴 모집");
        request.setPosition("백엔드 개발자");

        // When & Then
        CustomException exception = assertThrows(CustomException.class,
                () -> postingService.savePosting(companyId, request)
        );
        assertEquals(ExceptionCode.NOT_FOUND_COMPANY, exception.getExceptionCode());
    }

    @Test
    @DisplayName("등록o 사업자등록번호 - 채용공고 수정")
    public void testSaveCompany() {

        // Given
        Long postingId = 1L;
        Company company = new Company("existing Company", 123);
        PostingDto.PostingRequest request = new PostingDto.PostingRequest();
        request.setTitle("XX기업 인턴 모집");
        request.setPosition("백엔드 개발자");

        Posting existingPosting = new Posting(request, company);
        Mockito.when(postingRepository.findById(postingId)).thenReturn(Optional.of(existingPosting));

        PostingDto.PostingElementRequest request2 = new PostingDto.PostingRequest();
        request2.setTechnology("Java");
        request2.setDescription(null);
        request2.setReward(3000);
        request2.setEndDate(LocalDateTime.now().plusDays(7));

        // When
        BaseResponse<PostingDto.PostingResponse> response = postingService.updatePosting(postingId, request2);

        // Then
        assertEquals(ExceptionCode.UPDATE_POSTING_OK.getCode(), response.getCode());
        assertEquals(company.getId(), response.getResult().getCompanyId());
        assertEquals(existingPosting.getId(), response.getResult().getPostingId());
        assertEquals(existingPosting.getTechnology(), response.getResult().getTechnology());
        assertEquals(existingPosting.getDescription(), response.getResult().getDescription());
    }
}

