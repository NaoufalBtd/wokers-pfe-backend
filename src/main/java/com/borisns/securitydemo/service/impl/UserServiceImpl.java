package com.borisns.securitydemo.service.impl;

import com.borisns.securitydemo.dto.request.RegisterDto;
import com.borisns.securitydemo.dto.response.UserDTO;
import com.borisns.securitydemo.exception.exceptions.ApiRequestException;
import com.borisns.securitydemo.model.Freelancer;
import com.borisns.securitydemo.model.User;
import com.borisns.securitydemo.repository.UserRepository;
import com.borisns.securitydemo.service.FreelancerService;
import com.borisns.securitydemo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private FreelancerService freelancerService;
    @Override
    public UserDTO findById(Long id) throws ApiRequestException {
        try {
            User user = userRepository.findById(id).get();
            return new UserDTO(user);
        } catch (NoSuchElementException e) {
            throw new ApiRequestException("User with id '" + id + "' doesn't exist.");
        }
    }


    @Override
    public UserDTO findByUsername(String username) throws ApiRequestException {
        try {
            User user = userRepository.findByUsername(username);
            if(user == null) {
                throw new UsernameNotFoundException("User with username '" + username + "' doesn't exist.");
            }

            Freelancer freelancer = freelancerService.getByUserId(user.getId());

            user.setFreelancer(freelancer);

            return modelMapper.map(user, UserDTO.class);
        } catch (UsernameNotFoundException e) {
            throw new ApiRequestException("User with username '" + username + "' doesn't exist.");
        }
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(user -> new UserDTO(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO register(RegisterDto registerDto) {
        if(userRepository.findByUsername(registerDto.getUsername()) != null) {
            throw new ApiRequestException("User with username '" + registerDto.getUsername() + "' already exists.");
        }

        User user = modelMapper.map(registerDto, User.class);
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setEnabled(true);

        User savedUser = userRepository.save(user);
        Freelancer freelancer = new Freelancer();
        freelancer.setUser(savedUser);
        Freelancer savedFreelancer = freelancerService.createFreelancer(freelancer);
        savedUser.setFreelancer(savedFreelancer);
        savedUser = userRepository.save(savedUser);

        UserDTO userDTO = modelMapper.map(savedUser, UserDTO.class);
        return userDTO;
    }

    @Override
    public UserDTO save(User user) {
        return modelMapper.map(userRepository.save(user), UserDTO.class);
    }
}
