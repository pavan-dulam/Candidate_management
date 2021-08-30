package com.pavan.Candidate_management.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import com.pavan.Candidate_management.entities.Candidate;
import com.pavan.Candidate_management.repos.CandidateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {


    @Autowired
    CandidateRepository candidateRepository;
    @Override
    public List<Candidate> getAllCandidate() {
       
        return candidateRepository.getAllCandidates();
    }
    @Override
    public void saveCandidate(Candidate candidate) {
        this.candidateRepository.save(candidate);
        
    }
    @Override
    public Candidate getCandidateById(Long id) {
        Optional<Candidate> Optional= candidateRepository.findById(id);
        Candidate candidate=null;
        if(Optional.isPresent()) {
            candidate= Optional.get();
        }else{
            throw new RuntimeErrorException(null, "Candidate not found for id: " + id);
        }
        return candidate;
        
    }
    @Override
    public void deleteCandidateById(Long id) {
       this.candidateRepository.deleteById(id);
        
    }
}

