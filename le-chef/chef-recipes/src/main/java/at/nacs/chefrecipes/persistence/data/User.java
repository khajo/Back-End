package at.nacs.chefrecipes.persistence.data;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {


    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String userName;

    private String password;

//    @LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Ingredient> kitchen = new ArrayList<>();
}
