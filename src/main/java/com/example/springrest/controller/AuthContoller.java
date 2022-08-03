package com.example.springrest.controller;

import com.example.springrest.enums.Authorities;
import com.example.springrest.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springrest.service.AuthService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthContoller {
    AuthService authService;

    public AuthContoller(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return authService.getAuthorities(user);
    }
}
