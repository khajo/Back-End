package at.nacs.drhouseadmission;

import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class AddmissionID {


    public Patient getID(Patient patient) {
        patient.setId(UUID.randomUUID().toString());
        return patient;
    }
}
