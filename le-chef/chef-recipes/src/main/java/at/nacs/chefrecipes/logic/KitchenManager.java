package at.nacs.chefrecipes.logic;


import at.nacs.chefrecipes.persistence.data.Ingredient;
import at.nacs.chefrecipes.persistence.data.Kitchen;
import at.nacs.chefrecipes.persistence.repository.KitchenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class KitchenManager {

    private final KitchenRepository kitchenRepository;


    public void addIngredients(Ingredient ingredient, String userName) {
        Kitchen kitchen = getKitchenByUserName(userName);
        List<Ingredient> ingredients = kitchen.getIngredients();
        ingredients.remove(ingredient);
         kitchenRepository.save(kitchen);
    }

    public Kitchen getKitchenByUserName(String userName) {
        return kitchenRepository.findByUser_UserName(userName);
    }

    public Kitchen addKitchen(Kitchen kitchen) {
     return    kitchenRepository.save(kitchen);
    }

    public List<Kitchen> getAll() {
        return kitchenRepository.findAll();
    }


}
