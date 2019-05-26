package at.nacs.chefrecipes.logic;


import at.nacs.chefrecipes.persistence.demo.Recipe;
import at.nacs.chefrecipes.persistence.repository.RecipeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class RecipeManagerTest {


    @Autowired
    RecipeManager recipeManager;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    private List<Recipe> recipes;


    @BeforeEach
    void before() {
        recipeRepository.deleteAll();
        recipeRepository.save(recipes.get(0));
        recipeRepository.save(recipes.get(1));
    }


    @Test
    void addRecipe() {
        Recipe actual = recipeManager.addRecipe(recipes.get(2));
        Assertions.assertThat(actual.getId()).isNotNull();

    }

    @Test
    void getRecipes() {
        List<Recipe> actual = recipeManager.getRecipes();
        Assertions.assertThat(actual.size()).isEqualTo(2);
    }

    @Test
    void getRecipeByLabel() {
        String vegan = "vegan";
        List<Recipe> recipeByLabel = recipeManager.getRecipeByLabel(vegan);
        Assertions.assertThat(recipeByLabel.size()).isEqualTo(1);
    }

    @Test
    void getRecipeByOrigin() {
        String armenian = "Armenian";
        List<Recipe> recipeByOrigin = recipeManager.getRecipeByOrigin(armenian);
        Assertions.assertThat(recipeByOrigin.size()).isEqualTo(1);

    }
}