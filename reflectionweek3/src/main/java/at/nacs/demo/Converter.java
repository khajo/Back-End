package at.nacs.demo;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Converter {

    public List<Integer> getDigit(Integer digit) {
        return Stream.of(digit.toString())
                .map(e->e.split(""))
                .flatMap(e->Stream.of(e))
                .map(e->Integer.valueOf(e))
                .collect(Collectors.toList());
    }


}
