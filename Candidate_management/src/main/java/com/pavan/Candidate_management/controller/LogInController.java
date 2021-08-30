package com.pavan.Candidate_management.controller;

import com.pavan.Candidate_management.entities.Users;
import com.pavan.Candidate_management.repos.UserRepository;
import com.pavan.Candidate_management.services.CandidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LogInController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CandidateService candidateService;

    @GetMapping("/action/register")
    public String showRegister() {
       
        return "registration";
    }

    @PostMapping(value="/action/Registration" )
    public String saveUser(@ModelAttribute("user") Users user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String EncodedPassword=encoder.encode(user.getPassword());
        user.setPassword(EncodedPassword);
        userRepository.save(user);
        return "login";
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("listCandidates",candidateService.getAllCandidate() );
        return "index";
    }
}
