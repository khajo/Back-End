package at.nacs.drhousebed;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class Nurse {

    private final Treatment treatment;


    public String treat(String diagnosis) {
        Map<String, String> treatments = treatment.getTreatments();
        String treatment = treatments.getOrDefault(diagnosis, "no");
        return treatment;
    }

}
