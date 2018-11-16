package com.rizaldi.mongo.web.crud.controller;

import com.rizaldi.mongo.web.crud.model.FoodRecipe;
import com.rizaldi.mongo.web.crud.repository.FoodRecipeRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class FoodRecipeApiController {
    private final FoodRecipeRepository repository;

    public FoodRecipeApiController(FoodRecipeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("save")
    private FoodRecipe save(@ModelAttribute FoodRecipe recipe) {
        return repository.save(recipe);
    }
}
