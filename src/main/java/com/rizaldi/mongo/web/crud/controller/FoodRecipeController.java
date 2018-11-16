package com.rizaldi.mongo.web.crud.controller;

import com.rizaldi.mongo.web.crud.repository.FoodRecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FoodRecipeController {
    private static final Logger LOG = LoggerFactory.getLogger(FoodRecipeController.class);
    private static final int MAX_RECIPE_IN_PAGE = 10;
    private final FoodRecipeRepository repository;

    public FoodRecipeController(FoodRecipeRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public String viewRoot() {
        return "redirect:/list/0";
    }

    @GetMapping("/list/{pageNumber}")
    public String viewListRecipe(Model model, @PathVariable int pageNumber) {
        var page = PageRequest.of(pageNumber, MAX_RECIPE_IN_PAGE);
        var recipes = repository.findAll(page).getContent();
        model.addAttribute("recipes", recipes);
        model.addAttribute("startIndex", pageNumber * MAX_RECIPE_IN_PAGE + 1);
        LOG.info("found {} recipes", recipes.size());
        return "ListRecipe";
    }
}
