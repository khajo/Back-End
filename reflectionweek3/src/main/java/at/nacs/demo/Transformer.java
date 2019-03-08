package at.nacs.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Transformer {
    private final Map<Integer, String> moves;
    private final Converter converter;

    public List<String> gethandShakes(String digit) {
        List<Integer> digits = converter.getDigit(digit);
        return digits.stream().filter(e -> moves.containsKey(e)).map(e -> moves.get(e)).collect(Collectors.toList());
    }


}
