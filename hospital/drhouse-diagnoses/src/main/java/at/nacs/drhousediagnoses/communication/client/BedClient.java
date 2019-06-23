package at.nacs.drhousediagnoses.communication.client;

import at.nacs.drhousediagnoses.communication.dto.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BedClient {

    private final RestTemplate restTemplate;

    @Value("${bed.server.url}")
    private String bedUrl;


    public Patient postToBed(Patient patient) {
        return restTemplate.postForObject(bedUrl, patient, Patient.class);
    }
}
