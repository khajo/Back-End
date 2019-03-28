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
    private final AddmissionID addmissionID;

//
//    @Value("${addmimssion.server.url}")
//    private String url;


    @PostMapping
    Patient post(@RequestBody Patient person) {
        Patient patient = addmissionID.setID(person);
        restTemplate.postForObject("http://localhost:9002/patients", patient, Patient.class);
        return person;
    }

}
