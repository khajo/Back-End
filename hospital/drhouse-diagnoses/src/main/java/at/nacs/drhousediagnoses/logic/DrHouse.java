package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.Configuration.Diagnosis;
import at.nacs.drhousediagnoses.Configuration.ForwordPatient;
import at.nacs.drhousediagnoses.persistence.Patient;
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
        return forwordPatient.getDirections().getOrDefault(diagnosis, "Please Wait!!");
    }

}
