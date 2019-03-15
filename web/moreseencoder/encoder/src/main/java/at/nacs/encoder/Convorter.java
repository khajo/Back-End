package at.nacs.encoder;


import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class Convorter {


    public List<String> getLetters(String word) {
        return Stream.of(word)
                .map(e -> e.toUpperCase())
                .map(e -> e.split(""))
                .flatMap(e -> Stream.of(e))
                .collect(Collectors.toList());
    }


}
