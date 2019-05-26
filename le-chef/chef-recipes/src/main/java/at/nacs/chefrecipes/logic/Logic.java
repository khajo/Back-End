package at.nacs.chefrecipes.logic;


import at.nacs.chefrecipes.persistence.data.Ingredient;
import at.nacs.chefrecipes.persistence.data.Kitchen;
import at.nacs.chefrecipes.persistence.data.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Logic {

    private final RecipeManager recipeManager;
    private final KitchenManager kitchenManager;



    public List<Recipe> recipeRecommendations(String userName) {
        List<Recipe> recipes = recipeManager.getRecipes();
        Kitchen kitchenByUserName = kitchenManager.getKitchenByUserName(userName);
        List<Ingredient> ingredients = kitchenByUserName.getIngredients();
        return recipes.stream()
                .filter(e -> e.getIngredients().containsAll(ingredients))
                .collect(Collectors.toList());
    }



}
