package at.nacs.morse;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
@RequiredArgsConstructor
public class MorseEndpoint {


    private final MorseConverter morseConverter;


    @PostMapping
    String post(@RequestBody String word) {
        return morseConverter.convorter(word);
    }

}
