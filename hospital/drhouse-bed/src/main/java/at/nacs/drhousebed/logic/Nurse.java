package at.nacs.drhousebed.logic;


import at.nacs.drhousebed.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class Nurse {
    private final Map<String, String> treatments;



    public Patient treat(Patient patient) {
        String diagnosis = patient.getDiagnosis();
        String treatment = treatments.getOrDefault(diagnosis, "no");
        patient.setTreatment(treatment);
        return patient;
    }

}
