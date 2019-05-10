package at.nacs.chefrecipes.communication;


import at.nacs.chefrecipes.logic.RecipeManager;
import at.nacs.chefrecipes.persistence.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeEndpoint {

    private final RecipeManager recipeManager;

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
}
