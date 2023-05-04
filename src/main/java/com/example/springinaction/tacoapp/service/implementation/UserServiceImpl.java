package com.example.springinaction.tacoapp.service.implementation;

import com.example.springinaction.tacoapp.enums.Role;
import com.example.springinaction.tacoapp.exceptions.NoSuchUserExistsException;
import com.example.springinaction.tacoapp.exceptions.WrongPasswordException;
import com.example.springinaction.tacoapp.model.User;
import com.example.springinaction.tacoapp.repository.UserRepo;
import com.example.springinaction.tacoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    @Override
    public User registerUser(User user) {
        return null;
    }

    @Override
    public User login(String email, String password) {
        return null;
    }

    @Override
    public boolean authenticateUser(String email, String password)
            throws NoSuchUserExistsException, WrongPasswordException {
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepo.findFirstByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), authorities);
    }

    public User findByLogin(String login) {
        return userRepo.findByLogin(login);
    }

    public User getUserByAuthentication(Authentication authentication) {
        if (authentication == null) {
            return null;
        }
        String username = authentication.getName();
        return userRepo.findFirstByLogin(username);
    }


}
