package com.borisns.securitydemo.repository;

import com.borisns.securitydemo.model.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {
    Freelancer findByUserId(Long id);
}
