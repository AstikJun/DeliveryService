package com.example.springinaction.tacoapp.controller;

import com.example.springinaction.tacoapp.model.Order;
import com.example.springinaction.tacoapp.model.Taco;
import com.example.springinaction.tacoapp.model.User;
import com.example.springinaction.tacoapp.repository.OrderRepo;
import com.example.springinaction.tacoapp.repository.TacoRepo;
import com.example.springinaction.tacoapp.service.OrderService;
import com.example.springinaction.tacoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private TacoRepo tacoRepo;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private OrderService orderService;

    @GetMapping("/orderList")
    public String orderList(Model model) {
        List<Taco> tacos = tacoRepo.findAll();
        model.addAttribute("tacos", tacos);
        return "orderList";
    }

    @GetMapping("/orderForm")
    public ModelAndView orderForm() {
        ModelAndView modelAndView = new ModelAndView("orderForm");
        modelAndView.addObject("order", new Order());
        return modelAndView;
    }


}
