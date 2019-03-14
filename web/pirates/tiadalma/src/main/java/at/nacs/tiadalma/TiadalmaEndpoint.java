package at.nacs.tiadalma;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/dutchman")
public class TiadalmaEndpoint {



    @Value("${dutchman.server.url}")
    String url;


    @GetMapping
    String get() {
      //  String dutchmanChestUrl = restTemplate.getForObject(url, String.class);
        return url;
    }
}
