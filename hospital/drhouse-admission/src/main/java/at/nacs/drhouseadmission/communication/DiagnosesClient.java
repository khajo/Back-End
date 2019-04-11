package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class DiagnosesClient {

    private final RestTemplate restTemplate;


    @Value("${admission.server.url}")
    private String url;


    @PostMapping
    public Patient post(@RequestBody Patient patient) {
        return restTemplate.postForObject(url, patient, Patient.class);
    }

}
