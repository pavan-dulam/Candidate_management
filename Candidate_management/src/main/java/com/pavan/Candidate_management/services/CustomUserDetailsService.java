package com.pavan.Candidate_management.services;

import com.pavan.Candidate_management.entities.Users;
import com.pavan.Candidate_management.repos.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users= userRepository.findByEmail(email);
        if(users==null) {
            throw new UsernameNotFoundException(email+"not found");
        }

        return new CustomUserDetails(users);
    }
    
}
