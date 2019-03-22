package at.nacs.drhousediagnoses;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequiredArgsConstructor
public class AddmissionClient {

    private final RestTemplate restTemplate;
    private final DrHouse drHouse;

    @Value("${addmimssion.server.url}")
    private String url;


    @PostMapping
    Patient post(@RequestBody Patient patient1) {
        Patient patient = restTemplate.postForObject(url, patient1, Patient.class);
        String diagnosis = drHouse.getDiagnosis(patient.getSymptoms());
        patient.setDiagnosis(diagnosis);
        return patient;
    }

}
