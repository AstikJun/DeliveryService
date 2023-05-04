package com.example.springinaction.tacoapp.service;

import com.example.springinaction.tacoapp.exceptions.NoSuchUserExistsException;
import com.example.springinaction.tacoapp.exceptions.WrongPasswordException;
import com.example.springinaction.tacoapp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(User user);

    User registerUser(User user);

    User login(String email, String password);

    boolean authenticateUser(String email, String password) throws NoSuchUserExistsException, WrongPasswordException;

    User getUserByEmail(String email);


}
