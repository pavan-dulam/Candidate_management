package com.pavan.Candidate_management.controller;




import java.util.List;

import com.pavan.Candidate_management.entities.Candidate;
import com.pavan.Candidate_management.entities.Users;
import com.pavan.Candidate_management.repos.CandidateRepository;
import com.pavan.Candidate_management.repos.UserRepository;
import com.pavan.Candidate_management.services.CandidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CandidateController {
    
    @Autowired
    CandidateService candidateService;
    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    UserRepository usersRepository;

    @GetMapping("/")
    public String showCandidate(Model model) {
        List<Users> allUsers = usersRepository.findAllUsers();
        List<Candidate> allcandidates = candidateRepository.getAllCandidates();
        model.addAttribute("listCandidates",allcandidates);
        model.addAttribute("allUsers",allUsers);
        return "index";
    }

    @GetMapping("action/showAddCandidate")
    public String showAddCandidate() {
        
        return "addCandidates";
    }

   @RequestMapping(value ="service/addCandidate", method = RequestMethod.POST)
    public String addCandidate(@ModelAttribute("candidate")Candidate candidate) {
        candidateService.saveCandidate(candidate);
        return "redirect:/";
    }

    @GetMapping("action/showupdateCandidate/{id}")
    public String showupdateCandidate(@PathVariable(value = "id") Long id,Model model) {
       Candidate candidate = candidateService.getCandidateById(id);
        model.addAttribute("candidate",candidate );
        return "editCandidates";
    }

    @GetMapping("service/deleteCandidate/{id}")
    public String deleteCandidate(@PathVariable(value = "id") Long id,Model model) {
       this.candidateService.deleteCandidateById(id);
       return "redirect:/";
        
        
    }

    
}
