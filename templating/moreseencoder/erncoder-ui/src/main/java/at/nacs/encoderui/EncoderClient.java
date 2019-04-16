package at.nacs.encoderui;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class EncoderClient {

    private final RestTemplate restTemplate;

    @Value("${encoder.server.url}")
    private String encoderUrl;


    String sendToEncoder(String text) {
        return restTemplate.postForObject(encoderUrl, text, String.class);
    }

}
