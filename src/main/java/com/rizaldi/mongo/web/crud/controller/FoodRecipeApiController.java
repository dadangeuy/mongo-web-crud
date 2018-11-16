package com.rizaldi.mongo.web.crud.controller;

import com.rizaldi.mongo.web.crud.model.FoodRecipe;
import com.rizaldi.mongo.web.crud.repository.FoodRecipeRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("delete/{id}")
    private void delete(@PathVariable String id) {
        repository.deleteById(new ObjectId(id));
    }
}
