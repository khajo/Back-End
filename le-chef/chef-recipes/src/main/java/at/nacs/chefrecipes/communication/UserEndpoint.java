package at.nacs.chefrecipes.communication;


import at.nacs.chefrecipes.persistence.demo.Ingredient;
import at.nacs.chefrecipes.persistence.demo.User;
import at.nacs.chefrecipes.logic.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserEndpoint {

    private final UserManager userManager;


    @PostMapping
    public User post(@RequestBody User user) {
        return userManager.addUser(user);
    }

//    @PutMapping("/{id}/{ingredient}")
//    public void addIngredient(@PathVariable long id, @RequestBody Ingredient ingredient) {
//        userManager.addIngredient(id, ingredient);
//    }

}
