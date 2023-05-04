package com.example.springinaction.tacoapp.repository;

import com.example.springinaction.tacoapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findFirstByLogin(String login);

    boolean existsByEmail(String email);

    User findByLogin(String login);

    Optional<Object> findByEmail(String email);

}
