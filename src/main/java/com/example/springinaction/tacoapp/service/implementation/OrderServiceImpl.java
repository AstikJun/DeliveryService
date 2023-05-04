package com.example.springinaction.tacoapp.service.implementation;

import com.example.springinaction.tacoapp.model.Order;
import com.example.springinaction.tacoapp.repository.OrderRepo;
import com.example.springinaction.tacoapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}
