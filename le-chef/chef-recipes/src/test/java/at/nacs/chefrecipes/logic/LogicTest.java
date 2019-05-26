package at.nacs.chefrecipes.logic;

import at.nacs.chefrecipes.persistence.demo.Kitchen;
import at.nacs.chefrecipes.persistence.demo.Recipe;
import at.nacs.chefrecipes.persistence.demo.User;
import at.nacs.chefrecipes.persistence.repository.KitchenRepository;
import at.nacs.chefrecipes.persistence.repository.RecipeRepository;
import at.nacs.chefrecipes.persistence.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class LogicTest {


    @Autowired
    private Logic logic;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private KitchenManager kitchenManager;



    @Autowired
    private KitchenRepository kitchenRepository;

    @Autowired
    private List<Kitchen> kitchens;

    @Autowired
    private List<Recipe> recipes;

    @Autowired
    private User users;


    @BeforeEach
    void before() {
        userRepository.save(users);

        recipeRepository.deleteAll();
        recipeRepository.saveAll(recipes);
        kitchenRepository.deleteAll();
        kitchenRepository.saveAll(kitchens);
    }


    @Test
    void recipeRecommendations() {
//        String userName = "apig";
//        List<Recipe> recipes = logic.recipeRecommendations(userName);
//        Kitchen kitchenByUserName = kitchenManager.getKitchenByUserName(userName);
//
//        System.out.println(kitchenByUserName);
//        System.out.println(recipes.size());
//
//
//        System.out.println(this.recipes);
      kitchens.stream().map(e->e.getUser()).forEach(e-> System.out.println(e));
        System.out.println(users);
    }
}