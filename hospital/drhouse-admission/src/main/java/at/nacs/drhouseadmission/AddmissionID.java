package at.nacs.drhouseadmission;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class AddmissionID {


    public Patient setID(Patient patient) {
        patient.setId(UUID.randomUUID().toString());
        return patient;
    }
}
