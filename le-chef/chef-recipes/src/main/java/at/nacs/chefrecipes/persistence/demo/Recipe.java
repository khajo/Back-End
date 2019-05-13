package at.nacs.chefrecipes.persistence.demo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {


    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private String typ;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> label = new ArrayList<>();

    private String origin;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    @Builder.Default
    private List<Ingredient> ingredients= new ArrayList<>();

}
