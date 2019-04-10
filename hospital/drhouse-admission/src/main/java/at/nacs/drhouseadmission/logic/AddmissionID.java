package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class AddmissionID {


    public Patient setID(Patient patient) {
        patient.setId(UUID.randomUUID().toString());
        return patient;
    }
}
