package at.nacs.ex6propertiespart1properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootTest
class WeekTest {

    @Autowired
    Week week;

    @ParameterizedTest
    @CsvSource({
            "0,Monday",
            "1,Tuesady",
            "2,Wensday",
            "3,Thursday",
            "4,Freiday",
            "5,Saterday",
            "6,Sonnday",

    })

    void getDays(Integer index, String expected) {
//        List<String> days = Stream.of("Monday, Tuesady, Wensday, Thursday, Freiday, Saterday, Sonnday")
//                .map(e -> e.split(", "))
//                .flatMap(e -> Stream.of(e))
//                .collect(Collectors.toList());
        List<String> days = week.getDays();
        System.out.println(days);
        String day  = days.get(index);
       Assertions.assertEquals(expected,day);
    }
}