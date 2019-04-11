package at.nacs.drhousediagnoses.logic;


import at.nacs.drhousediagnoses.Configuration.Diagnosis;
import at.nacs.drhousediagnoses.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class DrHouse {

     private final Map<String, String> diagnosis;
    // private final Map<String, String> directions;

    public Patient setDiagnoses(Patient patient) {
        String symptoms = patient.getSymptoms();
        String patientWithDiagnosis = diagnosis.getOrDefault(symptoms, "PLease wait in the waiting room, I could't find the symptoms's diagnosis");
        patient.setDiagnosis(patientWithDiagnosis);
        return patient;

    }


//    public String send(Patient patient) {
//        String diagnosis = patient.getDiagnosis();
//        return directions.getOrDefault(diagnosis, "Please Wait!! I can't find forwarding address");
//    }

}
