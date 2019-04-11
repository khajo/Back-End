package at.nacs.drhousebed.communication;


import at.nacs.drhousebed.logic.Nurse;
import at.nacs.drhousebed.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AccountancyClient {

    private final RestTemplate restTemplate;
    private final Nurse nurse;


    @Value("${accountancy.server.url}")
    private String accountancyUrl;


    public Patient post(Patient perosn) {
        Patient patient = nurse.treat(perosn);
        return restTemplate.postForObject(accountancyUrl, patient, Patient.class);
    }
}
