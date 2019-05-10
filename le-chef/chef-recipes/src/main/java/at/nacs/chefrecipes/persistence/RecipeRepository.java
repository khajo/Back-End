package at.nacs.chefrecipes.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByOrigin(String origin);

    List<Recipe> findAllByLabel(String label);
}
