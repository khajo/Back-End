package at.nacs.chefrecipes.persistence;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonManager {

    private final PersonRepository personRepository;

    public Person  addUser(Person person) {
        return personRepository.save(person);
    }


    public void addIngredient(Long id, Ingredient ingredient) {
        Optional<Person> optionalUser = personRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return;
        }
        Person user = optionalUser.get();
        List<Ingredient> ingredients = user.getIngredients();
        ingredients.add(ingredient);
        personRepository.save(user);
    }


}
