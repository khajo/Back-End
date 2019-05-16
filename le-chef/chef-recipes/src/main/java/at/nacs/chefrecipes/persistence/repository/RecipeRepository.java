package at.nacs.chefrecipes.persistence.repository;

import at.nacs.chefrecipes.persistence.data.Ingredient;
import at.nacs.chefrecipes.persistence.data.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByOrigin(String origin);

    List<Recipe> findAllByLabel(String label);


    List<Recipe> findAllByIngredients(List<Ingredient> ingredients);

    List<Recipe> findAllByIngredientsContaining(List<Ingredient> ingredients);

}
