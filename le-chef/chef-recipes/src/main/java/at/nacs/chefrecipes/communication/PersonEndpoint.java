package at.nacs.chefrecipes.communication;


import at.nacs.chefrecipes.persistence.Ingredient;
import at.nacs.chefrecipes.persistence.Person;
import at.nacs.chefrecipes.persistence.PersonManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class PersonEndpoint {

    private final PersonManager personManager;


    @PostMapping
    public Person post(@RequestBody Person person) {
        return personManager.addUser(person);
    }

    @PutMapping("/{id}/{ingredient}")
    public void addIngredient(@PathVariable long id, @RequestBody Ingredient ingredient) {
        personManager.addIngredient(id, ingredient);
    }

}
