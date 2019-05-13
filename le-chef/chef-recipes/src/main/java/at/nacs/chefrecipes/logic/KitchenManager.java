package at.nacs.chefrecipes.logic;


import at.nacs.chefrecipes.persistence.demo.Ingredient;
import at.nacs.chefrecipes.persistence.demo.Kitchen;
import at.nacs.chefrecipes.persistence.repository.KitchenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class KitchenManager {

    private final KitchenRepository kitchenRepository;


    public Kitchen addIngredients(Ingredient ingredient, Long id) {
        Kitchen kitchen = kitchenRepository.findAllByUserId(id);
        List<Ingredient> ingredients = kitchen.getIngredients();
        ingredients.add(ingredient);
        return kitchenRepository.save(kitchen);
    }

}
