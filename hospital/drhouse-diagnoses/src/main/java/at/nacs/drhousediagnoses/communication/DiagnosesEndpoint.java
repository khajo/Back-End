package at.nacs.drhousediagnoses.communication;


import at.nacs.drhousediagnoses.Manager;
import at.nacs.drhousediagnoses.persistence.Patient;
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
        return manager.post(patient);
    }


}
