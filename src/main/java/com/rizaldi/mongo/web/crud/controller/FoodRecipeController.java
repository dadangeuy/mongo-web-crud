package com.rizaldi.mongo.web.crud.controller;

import com.rizaldi.mongo.web.crud.repository.FoodRecipeRepository;
import org.bson.types.ObjectId;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FoodRecipeController {
    private static final int MAX_RECIPE_IN_PAGE = 5;
    private final FoodRecipeRepository repository;

    public FoodRecipeController(FoodRecipeRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public String viewRoot() {
        return "redirect:/list/0";
    }

    @GetMapping("list/{pageNumber}")
    public String viewListRecipe(Model model, @PathVariable int pageNumber) {
        var page = PageRequest.of(pageNumber, MAX_RECIPE_IN_PAGE);
        var recipes = repository.findAll(page).getContent();
        model.addAttribute("recipes", recipes);
        model.addAttribute("startIndex", pageNumber * MAX_RECIPE_IN_PAGE + 1);
        model.addAttribute("currentPage", pageNumber);
        return "ListRecipe";
    }

    @GetMapping("update/{id}")
    public String updateListRecipe(Model model, @PathVariable String id) {
        var recipe = repository.findById(new ObjectId(id)).get();
        model.addAttribute("recipe", recipe);
        return "UpdateRecipe";
    }

    @GetMapping("create")
    public String updateListRecipe() {
        return "CreateRecipe";
    }
}
