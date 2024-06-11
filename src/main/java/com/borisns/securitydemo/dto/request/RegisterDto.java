package com.borisns.securitydemo.dto.request;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String userType;
    private String timezone;
}
