package com.example.springinaction.tacoapp.model;

import java.util.ArrayList;
import java.util.List;

public class TacoOrder {

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco){
        this.tacos.add(taco);
    }
}
