package com.example.springinaction.tacoapp.config;

import com.example.springinaction.tacoapp.enums.Role;
import com.example.springinaction.tacoapp.model.User;
import com.example.springinaction.tacoapp.service.implementation.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class SuccessAuthenticationHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserServiceImpl userService;


    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void onAuthenticationSuccess(
          HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByLogin(auth.getName());
        if (user.getRole().equals(Role.ADMIN)) {
            response.sendRedirect("/adminMain");
        } else if (user.getRole().equals(Role.USER)) {
            response.sendRedirect("/");
        }
    }
}

