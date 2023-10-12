package com.example.wantedpreonboardingbackend.posting.repository;

import com.example.wantedpreonboardingbackend.company.domain.Company;
import com.example.wantedpreonboardingbackend.posting.domain.Posting;
import com.example.wantedpreonboardingbackend.posting.dto.PostingDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PostingRepositoryTest {

    @Autowired
    private PostingRepository postingRepository;

    @Test
    @DisplayName("등록o 회사 - 채용공고 삭제")
    public void deleteById() {
        // Given
        Company company = new Company("existing Company", 123);

        PostingDto.PostingRequest request = new PostingDto.PostingRequest();
        request.setTitle("XX기업 인턴 모집");

        Posting posting = new Posting(request, company);
        postingRepository.save(posting);
        Long postingId = posting.getId();

        // When
        postingRepository.deleteById(postingId);

        // Then
        Optional<Posting> deletedPosting = postingRepository.findById(postingId);
        assertFalse(deletedPosting.isPresent());

    }
}