package at.nacs.chefrecipes.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person,Long> {

    Person findByUserName(String userName);

}
