package com.example.springrest.repository;

import com.example.springrest.enums.Authorities;
import com.example.springrest.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AuthRepository {

    private ConcurrentHashMap<User, List<Authorities>> authorities;


    public AuthRepository() {
        authorities = new ConcurrentHashMap<>();
        authorities.put(new User("vasya", "1111"), new ArrayList<>(Collections.singleton(Authorities.READ)));
    }

    public List<Authorities> getUserAuthorities(User user) {
        return getOrEmpty(user);
    }

    private List<Authorities> getOrEmpty(User user) {
        if (authorities.get(user) == null) {
            return new ArrayList<>();
        }
        return authorities.get(user);
    }
}
