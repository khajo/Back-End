package at.nacs.chefrecipes.persistence;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer amount;
    private String amountMeasuringUnit;


}
