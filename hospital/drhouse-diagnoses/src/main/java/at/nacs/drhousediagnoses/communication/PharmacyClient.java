package at.nacs.drhousediagnoses.communication;

import at.nacs.drhousediagnoses.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PharmacyClient {

    private final RestTemplate restTemplate;

    @Value("${pharmacy.server.url}")
    private String pharmacyUrl;

    public Patient postToPharmacy(Patient patient) {
        return restTemplate.postForObject(pharmacyUrl, patient, Patient.class);
    }
}
