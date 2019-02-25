package fruit.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fruit {
    String name;
    Long amount;


}
