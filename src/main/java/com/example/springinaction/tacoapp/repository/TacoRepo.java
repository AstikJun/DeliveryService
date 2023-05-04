package com.example.springinaction.tacoapp.repository;

import com.example.springinaction.tacoapp.model.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepo extends JpaRepository<Taco,Long> {
}
