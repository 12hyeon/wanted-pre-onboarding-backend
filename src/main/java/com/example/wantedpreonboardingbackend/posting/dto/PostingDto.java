package com.example.wantedpreonboardingbackend.posting.dto;

import com.example.wantedpreonboardingbackend.posting.domain.Posting;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

public class PostingDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class PostingElementRequest {
        @NotBlank
        private String position;
        private String technology;
        private String description;
        private int reward;
        private LocalDateTime endDate;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class PostingRequest extends PostingElementRequest {

        @NotBlank
        private String title;
    }

    @Getter
    public static class PostingResponse {
        private Long companyId;
        private Long postingId;
        private String title;
        private String position;
        private String technology;
        private String description;
        private int reward;
        private LocalDateTime endDate;

        public PostingResponse(Posting posting) {
            this.companyId = posting.getCompany().getId();
            this.postingId = posting.getId();
            this.title = posting.getTitle();
            this.position = posting.getPosition();
            this.technology = posting.getTechnology();
            this.description = posting.getDescription();
            this.reward = posting.getReward();
            this.endDate = posting.getEndDate();
        }
    }
}


