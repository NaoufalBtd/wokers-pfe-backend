package com.borisns.securitydemo.controller;

import com.borisns.securitydemo.dto.FreelancerDto;
import com.borisns.securitydemo.dto.FreelancerPersonalInfoDto;
import com.borisns.securitydemo.model.Freelancer;
import com.borisns.securitydemo.service.FreelancerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/freelancer")
public class FreelancerController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FreelancerService freelancerService;
//    @GetMapping("/{id}")
//public ResponseEntity<FreelancerDto> getFreelancer(@PathVariable Long id) {
//
//
//    }

    @PostMapping("/personal-info")
    public ResponseEntity<FreelancerDto> savePersonalInfo(@RequestBody FreelancerPersonalInfoDto freelancerPersonalInfoDto) {
        Freelancer freelancer = freelancerService.savePersonalInfo(freelancerPersonalInfoDto);
        return ResponseEntity.ok(modelMapper.map(freelancer, FreelancerDto.class));
    }

    @PostMapping("/bio")
    public ResponseEntity<FreelancerDto> saveBio(@RequestBody FreelancerDto freelancerDto) {
        Freelancer freelancer = freelancerService.saveBio(freelancerDto);
        return ResponseEntity.ok(modelMapper.map(freelancer, FreelancerDto.class));
    }
}
