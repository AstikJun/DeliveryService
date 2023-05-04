package com.example.springinaction.tacoapp.controller;

import com.example.springinaction.tacoapp.model.Taco;
import com.example.springinaction.tacoapp.repository.TacoRepo;
import com.example.springinaction.tacoapp.service.TacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TacoController {

    @Autowired
    private TacoRepo tacoRepo;

    @Autowired
    private TacoService tacoService;

    @GetMapping("/")
    public String home(Model model){
        List<Taco> tacos = tacoRepo.findAll();
        model.addAttribute("tacos",tacos);
        return "index";
    }
    @GetMapping("/add_taco")
    public ModelAndView addTaco(){
        ModelAndView modelAndView = new ModelAndView("addTaco");
        modelAndView.addObject("taco",new Taco());
        return modelAndView;
    }

    @PostMapping("/save_taco")
    public String saveTaco(@ModelAttribute(name = "taco") Taco taco){
        this.tacoService.saveTaco(taco);
        return "index";
    }
}
