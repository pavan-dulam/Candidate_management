package com.pavan.Candidate_management.repos;

import java.util.List;

import com.pavan.Candidate_management.entities.Candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long> {
    @Query(value ="select * from candidate", nativeQuery = true)    
    List<Candidate> getAllCandidates();
}
