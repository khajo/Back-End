package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.Patient;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import org.springframework.stereotype.Service;


@Service
public class PatientCreator {


    public Patient creat(PatientDTO patientDTO) {
        return Patient.builder()
                .uuid(patientDTO.getId())
                .name(patientDTO.getName())
                .build();
    }
}
