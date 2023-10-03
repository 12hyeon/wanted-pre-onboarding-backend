package com.example.wantedpreonboardingbackend.company.domain;

import com.example.wantedpreonboardingbackend.config.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor
public class Company extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @NotNull
    private long number;

    public Company(String name, long number) {
        this.name = name;
        this.number = number;
    }
}
