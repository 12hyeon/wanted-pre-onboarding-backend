package com.example.wantedpreonboardingbackend.posting.repository;

import com.example.wantedpreonboardingbackend.posting.domain.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {

    Posting save(Posting posting);
    Optional<Posting> findById(Long id);
    //List<Posting> findByCompanyId(Long companyId);

}
