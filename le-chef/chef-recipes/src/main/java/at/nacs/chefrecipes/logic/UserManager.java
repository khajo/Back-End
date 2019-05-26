package at.nacs.chefrecipes.logic;


import at.nacs.chefrecipes.persistence.data.User;
import at.nacs.chefrecipes.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager {

    private final UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }


//    public void addIngredient(Long id, Ingredient ingredient) {
//        Optional<User> optionalUser = userRepository.findById(id);
//        if (optionalUser.isEmpty()) {
//            return;
//        }
//        User user = optionalUser.get();
//        List<Ingredient> ingredients = user.getIngredients();
//        ingredients.add(ingredient);
//        userRepository.save(user);
//    }


}
