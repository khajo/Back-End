package at.nacs.chefrecipes.logic;


import at.nacs.chefrecipes.persistence.data.Ingredient;
import at.nacs.chefrecipes.persistence.data.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Logic {

    private final RecipeManager recipeManager;
    private final KitchenManager kitchenManager;


    



//    public List<Recipe> recipeRecommendations(String userName) {
//        List<Recipe> recipes = recipeManager.getRecipes();
//        Kitchen kitchenByUserName = kitchenManager.getKitchenByUserName(userName);
//        List<Ingredient> ingredients = kitchenByUserName.getIngredients();
//        List<Ingredient> allMöglichkeiten = getAllMöglichkeiten(ingredients);
//
//
//        return null;
//    }
//
//    private List<Ingredient> getAllMöglichkeiten(List<Ingredient> ingredients) {
//        return IntStream.rangeClosed(ingredients.size())
//                .mapToObj(e->ingredients.remove(e))
//                .collect(Collectors.toList());
//    }

}
