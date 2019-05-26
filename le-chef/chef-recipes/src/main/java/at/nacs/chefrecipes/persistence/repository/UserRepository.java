package at.nacs.chefrecipes.persistence.repository;

import at.nacs.chefrecipes.persistence.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
