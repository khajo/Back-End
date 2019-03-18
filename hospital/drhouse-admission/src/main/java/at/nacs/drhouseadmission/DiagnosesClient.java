package at.nacs.drhouseadmission;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class DiagnosesClient {

    private final RestTemplate restTemplate;


    @Value("${diagnoses.server.url}")
    String url;

    @PostMapping
    Patient  post(@RequestBody Patient patient) {
        return restTemplate.postForObject(url, patient, Patient.class);
    }



}
