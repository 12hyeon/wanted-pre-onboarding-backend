package com.example.wantedpreonboardingbackend.posting.domain;

import com.example.wantedpreonboardingbackend.company.domain.Company;
import com.example.wantedpreonboardingbackend.config.BaseEntity;
import com.example.wantedpreonboardingbackend.posting.dto.PostingDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Posting extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String position;
    private String technology;
    private String description;

    @ColumnDefault("0")
    private int reward;

    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Builder
    public Posting(PostingDto.PostingRequest request, Company company) {
        this.title = request.getTitle();
        this.position = request.getPosition();
        this.technology = request.getTechnology();
        this.description = request.getDescription();
        this.reward = request.getReward();
        this.endDate = (request.getEndDate() != null) ? request.getEndDate() : LocalDateTime.now().plusDays(7);
        this.company = company;
    }

    // 연관관계 메서드

    public void addPosting(Company company) {
        this.company = company;
        company.getPostings().add(this);
    }

    public void removePosting() {
        company.getPostings().remove(this);
    }

    public void update(PostingDto.PostingElementRequest request) {
        this.position = request.getPosition();
        this.technology = request.getTechnology();
        this.description = request.getDescription();
        this.reward = request.getReward();
        this.endDate = (request.getEndDate() != null) ? request.getEndDate() : LocalDateTime.now().plusDays(7);
    }
}
