package Bean.view;


import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Stream;
@UtilityClass
public class Analyzer {



    public void display(List<List<String>>lists) {
         lists.stream().flatMap(e-> Stream.of(e)).forEach(e-> System.out.println(e.get(0)+e.get(1)+e.get(2)));
    }





}
