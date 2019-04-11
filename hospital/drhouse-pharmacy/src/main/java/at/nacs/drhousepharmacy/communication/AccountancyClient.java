package at.nacs.drhousepharmacy.communication;


import at.nacs.drhousepharmacy.logic.Apothecary;
import at.nacs.drhousepharmacy.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AccountancyClient {

    private final RestTemplate restTemplate;
    private final Apothecary apothecary;


    @Value("${accountancy.server.url}")
    private String accountancyUrl;


    public Patient post(Patient person) {
        Patient patient = apothecary.giveMedicament(person);
        return restTemplate.postForObject(accountancyUrl, patient, Patient.class);
    }
}
