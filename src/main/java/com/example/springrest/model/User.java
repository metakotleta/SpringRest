package com.example.springrest.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class User {
    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    private String name;
    private String pass;

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && pass.equals(user.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pass);
    }
}
