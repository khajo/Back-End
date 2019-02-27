package nacs.reflection.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PrimeAdderTest {

    @Autowired
    PrimeAdder primeAdder;

    @ParameterizedTest
    @CsvSource({

            "10, 129",
            "20, 639",
            "100, 24133",
    })
    void counter(Integer number, Integer expected) {
        Integer result = primeAdder.counter(number);
        Assertions.assertEquals(expected, result);


    }
}