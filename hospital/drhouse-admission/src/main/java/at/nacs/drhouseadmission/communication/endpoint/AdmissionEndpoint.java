package at.nacs.drhouseadmission.communication.endpoint;

import at.nacs.drhouseadmission.communication.dto.Patient;
import at.nacs.drhouseadmission.logic.PatientManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class AdmissionEndpoint {

    private final PatientManager patientManager;

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        return patientManager.post(patient);
    }


}
