//package at.nacs.chefrecipes.communication;
//
//
//import at.nacs.chefrecipes.logic.IngredientManager;
//import at.nacs.chefrecipes.persistence.Ingredient;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class IngredientEndpoint {
//
//    private final IngredientManager ingredientManager;
//
//
//
//    @PostMapping("/ingredient")
//    public Ingredient postIngredient(@RequestBody Ingredient ingredient) {
//        return ingredientManager.addIngredient(ingredient);
//    }
//
//
//
//}
