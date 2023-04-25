package com.example.springinaction.tacoapp.model;

import com.example.springinaction.tacoapp.enums.Type;
import lombok.Data;

@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;


}
