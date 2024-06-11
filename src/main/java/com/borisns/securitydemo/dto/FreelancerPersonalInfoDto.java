package com.borisns.securitydemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FreelancerPersonalInfoDto {
    private Long id;
    private  String firstName;
    private String lastName;
    private String email;
    private String role;
    private String country;
}
