package at.nacs.chefrecipes.communication;


import at.nacs.chefrecipes.logic.KitchenManager;
import at.nacs.chefrecipes.persistence.data.Ingredient;
import at.nacs.chefrecipes.persistence.data.Kitchen;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kitchen")
public class KitchenEndpoint {

    private final KitchenManager kitchenManager;


    @PostMapping
    public Kitchen post(@RequestBody Kitchen kitchen) {
        return kitchenManager.addKitchen(kitchen);
    }

    @PutMapping("/{userName}")
    public void addIngredient(@PathVariable String userName, @RequestBody Ingredient ingredient) {
        kitchenManager.addIngredients(ingredient,userName);
    }

    @GetMapping
    public List<Kitchen> getAllKitchen() {
        return kitchenManager.getAll();
    }

}
