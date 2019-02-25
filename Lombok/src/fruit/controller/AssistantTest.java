package fruit.controller;

import fruit.model.Fruit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AssistantTest {

    @Test
    void getFruits() {
        List<Fruit> fruits = Assistant.getFruits("fruit/testFile.txt");
        List<Fruit> expectedList= Arrays.asList(Fruit.builder().name("Apple").amount(1L).build(),Fruit.builder().name("Watermelon").amount(1L).build(),Fruit.builder().name("Orange").amount(2L).build(),Fruit.builder().name("Banana").amount(1L).build());
        Assertions.assertEquals(expectedList,fruits);
        System.out.println(fruits);
    }
}