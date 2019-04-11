package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class Admission {


    public Patient setId(Patient patient) {
        String id = UUID.randomUUID().toString();
        patient.setId(id);
        return patient;
    }
}
