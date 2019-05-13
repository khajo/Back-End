package at.nacs.chefrecipes.communication;


import at.nacs.chefrecipes.logic.KitchenManager;
import at.nacs.chefrecipes.persistence.demo.Ingredient;
import at.nacs.chefrecipes.persistence.demo.Kitchen;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kitchen")
public class KitchenEndpoint {

    private final KitchenManager kitchenManager;


    @PostMapping("/{id}")
    public Kitchen post(@RequestBody Ingredient ingredient, @PathVariable Long id) {
        return kitchenManager.addIngredients(ingredient, id);
    }

//    @PutMapping("/{id}/{ingredient}")
//    public void addIngredient(@PathVariable long id, @RequestBody Ingredient ingredient) {
//        userManager.addIngredient(id, ingredient);
//    }

}
