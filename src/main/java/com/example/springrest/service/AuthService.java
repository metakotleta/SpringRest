package com.example.springrest.service;

import com.example.springrest.enums.Authorities;
import com.example.springrest.exception.InvalidCredentials;
import com.example.springrest.exception.UnauthorizedUser;
import com.example.springrest.model.User;
import org.springframework.stereotype.Service;
import com.example.springrest.repository.AuthRepository;

import java.util.List;

@Service
public class AuthService {
    AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> userAuthorities = authRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
