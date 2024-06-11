package com.borisns.securitydemo.controller;

import com.borisns.securitydemo.dto.response.UserDTO;
import com.borisns.securitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String username) {
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }
}
