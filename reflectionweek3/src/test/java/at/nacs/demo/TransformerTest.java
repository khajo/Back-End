package at.nacs.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class TransformerTest {

    @Autowired
    Transformer transformer;


    @ParameterizedTest
    @CsvSource({

            "23569,thumb touches back/little finger grab/tickles over palm",
            "35,little finger grab/tickles over palm",
            "14, /",
    })
    void gethandShakes(String digit,String text) {
        List<String> expected = Stream.of(text).map(e -> e.split("/")).flatMap(e -> Stream.of(e)).collect(Collectors.toList());
        List<String> actual = transformer.gethandShakes(digit);
        Assertions.assertEquals(expected, actual);
    }
}
