package at.nacs.morse;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MorseConverter {


    private final Map<String, String> morseMap;


    public String convorter(String letter) {
        return Stream.of(letter)
                .filter(e -> morseMap.containsKey(e))
                .map(e -> morseMap.get(e))
                .collect(Collectors.joining());
    }


}


