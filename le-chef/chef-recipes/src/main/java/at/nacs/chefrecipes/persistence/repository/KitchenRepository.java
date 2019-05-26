package at.nacs.chefrecipes.persistence.repository;

import at.nacs.chefrecipes.persistence.demo.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KitchenRepository  extends JpaRepository<Kitchen,Long> {


    Kitchen findByUser_UserName(String userName);

}
