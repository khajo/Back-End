package at.nacs.drhousediagnoses;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class DiagnosesEndpoint {

    @PostMapping
    Patient post(@RequestBody  Patient patient) {
        patient.setDiagnosis("Stop drinking");
        return patient;
    }


}
