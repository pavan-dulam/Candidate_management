package com.pavan.Candidate_management.services;

import java.util.List;

import com.pavan.Candidate_management.entities.Candidate;

public interface CandidateService {
    List<Candidate> getAllCandidate();
    void saveCandidate(Candidate candidate);
    
    Candidate getCandidateById(Long id);
    void deleteCandidateById(Long id);
   
}
