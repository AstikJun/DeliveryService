package com.example.springinaction.tacoapp.repository;

import com.example.springinaction.tacoapp.model.OrderTaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTacoRepo extends JpaRepository<OrderTaco, Long> {
}
