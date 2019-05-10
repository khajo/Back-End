package at.nacs.chefrecipes.persistence;


import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Person {


    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String userName;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients = new ArrayList<>();
}
