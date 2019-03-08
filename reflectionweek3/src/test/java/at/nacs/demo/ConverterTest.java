package at.nacs.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConverterTest {

    @Autowired
    Converter converter;

    @ParameterizedTest
    @CsvSource({

            "23569,5",
            "35,2",
    })
    void getDigit(String digit, Integer expected) {
        List<Integer> digits = converter.getDigit(digit);
        Integer size = digits.size();
        Assertions.assertEquals(expected, size);
    }
}