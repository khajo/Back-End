package at.nacs.jacksparrow;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class tiadalmaClient {

    private final RestTemplate restTemplate;

    @Value("${tiadalma.server.url}")
    String url;

    String get() {
        String udtchmanUrl = restTemplate.getForObject(url, String.class);
        return udtchmanUrl;
    }


    String getItem() {
        String item = restTemplate.getForObject(get(), String.class);
        return item;
    }

}
