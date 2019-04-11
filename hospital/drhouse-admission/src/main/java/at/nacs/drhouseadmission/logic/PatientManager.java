package at.nacs.drhouseadmission.logic;


import at.nacs.drhouseadmission.communication.DiagnosesClient;
import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientManager {


    private final Admission admission;
    private final DiagnosesClient diagnosesClient;


    public Patient post(Patient patient) {
        Patient patientWithId = admission.setId(patient);
        return diagnosesClient.post(patientWithId);
    }
}
