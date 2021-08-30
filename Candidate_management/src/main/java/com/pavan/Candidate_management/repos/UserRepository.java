package com.pavan.Candidate_management.repos;


import java.util.List;

import com.pavan.Candidate_management.entities.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users  findByEmail(String email);
    @Query(value ="select * from user", nativeQuery = true) 
    List<Users> findAllUsers();
}
