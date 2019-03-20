package at.nacs.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequiredArgsConstructor
public class CupClient {

    private final RestTemplate restTemplate;
    private final Trickster trickster;


    @GetMapping
    String getToPlay() {
        trickster.delete().stream().forEach(e -> restTemplate.delete(e));
        String url = trickster.putCoin();
        restTemplate.put(url, Void.class);
        return "The game hast started";
    }

    @GetMapping("/{number}")
    Boolean get(@PathVariable Integer number) {
        String url = trickster.choosedUrl(number);
        return restTemplate.getForObject(url, Boolean.class);

    }
}
