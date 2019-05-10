package at.nacs.chefrecipes.logic;


import at.nacs.chefrecipes.persistence.Recipe;
import at.nacs.chefrecipes.persistence.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeManager {

    private final RecipeRepository recipeRepository;

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    public List<Recipe> getRecipeByLabel(String label) {
        return recipeRepository.findAllByLabel(label);
    }

    public List<Recipe> getRecipeByOrigin(String origin) {
        return recipeRepository.findByOrigin(origin);
    }
}
