package Bean.controller;

import lombok.experimental.UtilityClass;
import Bean.model.Bean;
import Bean.model.Beans;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class CanFiller {

    public List<Bean> fill( Integer limit){
       return IntStream.generate(()->0)
               .limit(limit)
                .mapToObj(n-> getBean()).collect(Collectors.toList());
    }

    private static Bean getBean() {

        return Beans.getBeans().get(new Random().nextInt(Beans.getBeans().size()));
    }



}
