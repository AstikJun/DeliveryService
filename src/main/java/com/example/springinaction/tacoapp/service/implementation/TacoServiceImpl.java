package com.example.springinaction.tacoapp.service.implementation;

import com.example.springinaction.tacoapp.model.Taco;
import com.example.springinaction.tacoapp.repository.TacoRepo;
import com.example.springinaction.tacoapp.service.TacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TacoServiceImpl implements TacoService {
    @Autowired
    private TacoRepo tacoRepo;

    @Override
    public Taco saveTaco(Taco taco){
        return tacoRepo.save(taco);
    }

}
