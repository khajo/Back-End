package at.nacs.chefrecipes.persistence.demo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(exclude = "id")
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer amount;
    private String amountMeasuringUnit;


}
