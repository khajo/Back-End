package fruit.view;

import fruit.controller.Assistant;
import lombok.experimental.UtilityClass;



@UtilityClass
public class FruitCounter {


    public void display(String path) {
        System.out.println("These are all our tasteful fruits:");
  Assistant.getFruits(path).stream().forEach(e-> System.out.println(e.getAmount()+" "+e.getName()));
    }

}
