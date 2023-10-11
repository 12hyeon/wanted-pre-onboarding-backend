package com.example.wantedpreonboardingbackend.company.domain;

import com.example.wantedpreonboardingbackend.config.BaseEntity;
import com.example.wantedpreonboardingbackend.posting.domain.Posting;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(unique = true)
    private int number;

    @NotBlank
    private String name;

    @Builder
    public Company(String name, int number) {
        this.name = name;
        this.number = number;
    }
}
