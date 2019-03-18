package at.nacs.drhouseadmission;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {


    @PostMapping()
    Patient post(@RequestBody Patient patient) {
        patient.setId(UUID.randomUUID().toString());
        return patient;
    }


}
