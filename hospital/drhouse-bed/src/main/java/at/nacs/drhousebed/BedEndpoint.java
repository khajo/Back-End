package at.nacs.drhousebed;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class BedEndpoint {

    private final RestTemplate restTemplate;
    private final BedManeger manager;


    @Value("${addmimssion.server.url}")
    private String url;

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        Patient patient1 = manager.add(patient);

        return restTemplate.postForObject(url, patient1, Patient.class);
    }

}
