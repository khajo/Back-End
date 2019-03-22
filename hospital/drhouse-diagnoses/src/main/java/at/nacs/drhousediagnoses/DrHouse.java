package at.nacs.drhousediagnoses;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrHouse {

    private final Diagnosis diagnosis;


    public String getDiagnosis(String symptoms) {
        String dignosis = diagnosis.getDiagnosis().getOrDefault(symptoms, "PLease wait in the waiting room");
        System.out.println(dignosis);
        return dignosis;
    }

}
