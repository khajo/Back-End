package fruit.controller;

import ex9.FileReader;
import fruit.model.Fruit;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;
@UtilityClass
public class Assistant {


    public List<Fruit> getFruits(String path) {
        return new FileReader().getlines(path).stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .map(e -> Fruit.builder().name(e.getKey()).amount(e.getValue()).build() )
                .collect(Collectors.toList());
    }
}
