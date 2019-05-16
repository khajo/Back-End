package at.nacs.chefrecipes.persistence.data;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer amount;
    private String amountMeasuringUnit;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(name, that.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
