package at.nacs.drhousediagnoses;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class DiagnosesEndpoint {

    private final Manager manager;


    @PostMapping
    Patient post(@RequestBody Patient patient) {
        Patient patient1 = manager.post(patient);

        return patient1;
    }


}
