package at.nacs.encoder;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class EncoderClient {

        private final RestTemplate restTemplate;
        private final Convorter convorter;


        @Value("${morse.server.url}")
        String url;


        @PostMapping
        public String translate(@RequestBody String word) {
            List<String> letters = convorter.getLetters(word);
            String symbols = letters.stream()
                    .map(e -> getString(e))
                    .collect(Collectors.joining());
            return symbols;
        }

    private String getString(@RequestBody String letter) {
        return restTemplate.postForObject(url, letter, String.class);
    }
}
