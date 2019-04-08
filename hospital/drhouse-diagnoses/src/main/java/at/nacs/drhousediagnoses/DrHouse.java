package at.nacs.drhousediagnoses;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrHouse {

    private final Diagnosis diagnosis;
    private final ForwordPatient forwordPatient;


    public Patient getDiagnoses(Patient patient) {
        String symptoms = patient.getSymptoms();
        String patientdiagnosis = diagnosis.getDiagnosis().getOrDefault(symptoms, "PLease wait in the waiting room");
         patient.setDiagnosis(patientdiagnosis);
        return patient;

    }


    public String send(Patient patient) {
        String diagnosis = patient.getDiagnosis();
        return forwordPatient.getForwords().getOrDefault(diagnosis, "I d'not know");
    }

}
