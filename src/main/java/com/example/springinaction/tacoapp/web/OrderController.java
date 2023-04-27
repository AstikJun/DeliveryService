package com.example.springinaction.tacoapp.web;

import com.example.springinaction.tacoapp.model.Taco;
import com.example.springinaction.tacoapp.model.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors,
                              SessionStatus sessionStatus) {
        if(errors.hasErrors()){
            return "orderForm";
        }
        log.info("Order submitted:{}", tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }

}
