package at.nacs.chefrecipes.persistence.repository;

import at.nacs.chefrecipes.persistence.demo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
