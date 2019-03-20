package at.nacs.drhousediagnoses;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrHouse {

    private final Diagnosis diagnosis;


    public String getDiagnosis(String symptoms) {
        String dignosis = diagnosis.getDiagnosisMap().getOrDefault(symptoms, "no");
        System.out.println(dignosis);
        return dignosis;
    }

}
