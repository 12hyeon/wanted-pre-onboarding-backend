package com.example.wantedpreonboardingbackend.posting.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

public class PostingDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class PostingRequest {
        private int companyNumber;

        @NotBlank
        private String title;
        @NotBlank
        private String position;
        private String technology;
        private String description;
        private int reward;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
    }
}
