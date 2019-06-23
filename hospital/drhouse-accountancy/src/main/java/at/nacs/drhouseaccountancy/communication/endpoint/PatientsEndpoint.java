package at.nacs.drhouseaccountancy.communication.endpoint;


import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.logic.Accountancy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {

    private final Accountancy accountancy;

    @PostMapping
    void post(@RequestBody PatientDTO patientDTO) {
        accountancy.invoice(patientDTO);
    }


}
