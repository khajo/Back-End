package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.controller.AddmissionID;
import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequiredArgsConstructor
public class PatientManager {

    private final RestTemplate restTemplate;
    private final AddmissionID addmissionID;


    @Value("${admission.server.url}")
    private String url;


    @PostMapping
   public Patient post(@RequestBody Patient person) {
        Patient patient = addmissionID.setID(person);
        return restTemplate.postForObject(url, patient, Patient.class);
    }

}
