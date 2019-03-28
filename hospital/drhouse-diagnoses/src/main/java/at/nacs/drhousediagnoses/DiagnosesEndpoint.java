package at.nacs.drhousediagnoses;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class DiagnosesEndpoint {

    private final Client client;


    @PostMapping
    Patient post(@RequestBody Patient patient) {
        Patient patient1 = client.post(patient);

        return patient1;
    }


}
