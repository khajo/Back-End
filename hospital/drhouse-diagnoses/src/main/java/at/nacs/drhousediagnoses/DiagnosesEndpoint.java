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

    private final DrHouse doktor;

    @PostMapping
    Patient post(@RequestBody  Patient patient) {
        String diagnosis = doktor.getDiagnosis(patient.getSymptoms());
        patient.setDiagnosis(diagnosis);
        return patient;
    }


}
