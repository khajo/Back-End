package at.nacs.chefrecipes.communication;


import at.nacs.chefrecipes.logic.Logic;
import at.nacs.chefrecipes.logic.RecipeManager;
import at.nacs.chefrecipes.persistence.data.Ingredient;
import at.nacs.chefrecipes.persistence.data.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeEndpoint {

    private final RecipeManager recipeManager;
    private final Logic logic;

    @GetMapping("/recipes")
    public List<Recipe> getRecipes() {
        return recipeManager.getRecipes();
    }


    @PostMapping("/recipe")
    public Recipe post(@RequestBody Recipe recipe) {
        return recipeManager.addRecipe(recipe);
    }

    @GetMapping("/label/{label}")
    public List<Recipe> getByLabel(@PathVariable String label) {
        return recipeManager.getRecipeByLabel(label);
    }

    @GetMapping("/origin/{origin}")
    public List<Recipe> getByOrigin(@PathVariable String origin) {
        return recipeManager.getRecipeByOrigin(origin);
    }


    @GetMapping("/recipe/{userName}")
    public List<Recipe> getRecommendations(@PathVariable String userName) {
        return logic.recipeRecommendations(userName);
    }

    @GetMapping("/recipes/ingredients")
    public List<Recipe> getByIngredients(@RequestBody List<Ingredient> ingredients) {
        return recipeManager.recipeRecommendations(ingredients);

    }

}