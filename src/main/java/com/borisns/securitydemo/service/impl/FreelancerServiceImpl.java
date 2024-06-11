package com.borisns.securitydemo.service.impl;

import com.borisns.securitydemo.dto.FreelancerDto;
import com.borisns.securitydemo.dto.FreelancerPersonalInfoDto;
import com.borisns.securitydemo.model.Freelancer;
import com.borisns.securitydemo.model.User;
import com.borisns.securitydemo.repository.FreelancerRepository;
import com.borisns.securitydemo.service.FreelancerService;
import com.borisns.securitydemo.service.UserService;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class FreelancerServiceImpl implements FreelancerService {

    @Autowired
    private FreelancerRepository freelancerRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Freelancer createFreelancer(Freelancer freelancer) {
        return freelancerRepository.save(freelancer);
    }

    @Override
    public Freelancer getById(Long id) {
        return freelancerRepository.findById(id).orElseThrow();
    }


    @Override
    public Freelancer getByUserId(Long id) {
        return freelancerRepository.findByUserId(id);
    }

    @Override
    public Freelancer savePersonalInfo(FreelancerPersonalInfoDto freelancerPersonalInfoDto) {
        Freelancer freelancer = getById(freelancerPersonalInfoDto.getId());
        User user = freelancer.getUser();

        user.setFirstName(freelancerPersonalInfoDto.getFirstName());
        user.setLastName(freelancerPersonalInfoDto.getLastName());
        user.setEmail(freelancerPersonalInfoDto.getEmail());
        user.setCountry(freelancerPersonalInfoDto.getCountry());
        userService.save(user);

        freelancer.setRole(freelancerPersonalInfoDto.getRole());
        return freelancerRepository.save(freelancer);
    }

    @Override
    public Freelancer saveBio(FreelancerDto freelancerDto) {
        Freelancer freelancer = getById(freelancerDto.getId());
        freelancer.setBio(freelancerDto.getBio());
        return freelancerRepository.save(freelancer);
    }

//    @Override
//    public FreelancerDto register(RegisterDto registerDto) {
//
//
//    }
}
