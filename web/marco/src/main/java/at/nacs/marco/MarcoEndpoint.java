package at.nacs.marco;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/say")
public class MarcoEndpoint {

    private final RestTemplate restTemplate;


    @Value("${polo.server.url}")
    String url;


    @PostMapping
    public String say(@RequestBody String message) {
        String say = restTemplate.postForObject(url, message, String.class);
        return say;
    }

}
