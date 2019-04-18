package at.nacs.administrationui;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AdmissionClient {

    private final RestTemplate restTemplate;

    @Value("${admission.url}")
    private String admissionUrl;


    public Patient send(Patient patient) {
        return restTemplate.postForObject(admissionUrl, patient, Patient.class);
    }

}
