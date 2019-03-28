package at.nacs.drhousediagnoses;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequiredArgsConstructor
public class Client {

    private final RestTemplate restTemplate;
    private final DrHouse drHouse;


    @Value("${bed.server.url}")
    private String bedUrl;

    @Value("${pharmacy.server.url}")
    private String pharmacyUrl;


    @PostMapping
    Patient post(@RequestBody Patient patient) {
        String symptoms = patient.getSymptoms();
        String diagnosis = drHouse.getDiagnosis(symptoms);
        patient.setDiagnosis(diagnosis);
        String send = drHouse.send(diagnosis);
        if (send.equals("bed")) {
            return restTemplate.postForObject(bedUrl, patient, Patient.class);
        }
        return restTemplate.postForObject(pharmacyUrl, patient, Patient.class);
    }
}
