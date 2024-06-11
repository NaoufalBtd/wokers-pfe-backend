package com.borisns.securitydemo.service;

import com.borisns.securitydemo.dto.request.RegisterDto;
import com.borisns.securitydemo.dto.response.UserDTO;
import com.borisns.securitydemo.model.User;

import java.util.List;

public interface UserService {

    UserDTO findById(Long id);
    UserDTO findByUsername(String username);
    List<UserDTO> findAll();

    UserDTO register(RegisterDto registerDto);

    UserDTO save(User user);
}
