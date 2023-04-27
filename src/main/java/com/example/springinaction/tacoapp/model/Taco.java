package com.example.springinaction.tacoapp.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Taco {
    @NotNull
    @Size(min = 5, message = "Name should be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must pick at leas t  1 ingredient")
    private List<Ingredient> ingredients;

}
