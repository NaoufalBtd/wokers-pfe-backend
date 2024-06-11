package com.borisns.securitydemo.service;

import com.borisns.securitydemo.dto.FreelancerDto;
import com.borisns.securitydemo.dto.FreelancerPersonalInfoDto;
import com.borisns.securitydemo.model.Freelancer;

public interface FreelancerService {

    Freelancer createFreelancer(Freelancer freelancer);

    Freelancer getById(Long id);

    Freelancer getByUserId(Long id);

    Freelancer savePersonalInfo(FreelancerPersonalInfoDto freelancerPersonalInfoDto);

    Freelancer saveBio(FreelancerDto freelancerDto);
}
