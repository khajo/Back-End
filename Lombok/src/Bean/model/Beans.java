package Bean.model;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
@UtilityClass
public class Beans {
   private List<Bean> beans= Arrays.asList( Bean.builder().color("white").build(), Bean.builder().color("black").build());


   public List<Bean> getBeans(){
       return beans;
   }
}
