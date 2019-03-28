package at.nacs.drhousediagnoses;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrHouse {

    private final Diagnosis diagnosis;
    private final ForwordPatient forwordPatient;


    public String getDiagnosis(String symptoms) {
        return diagnosis.getDiagnosis().getOrDefault(symptoms, "PLease wait in the waiting room");
    }


    public String send(String diagnosis) {
        return forwordPatient.getForwords().getOrDefault(diagnosis, "I d'not know");
    }

}
