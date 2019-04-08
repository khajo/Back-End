package at.nacs.drhousepharmacy.logic;


import at.nacs.drhousepharmacy.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class Apothecary {
    private final Map<String, String> medicaments;

    public Patient giveMedicament(Patient patient) {
        String diagnosis = patient.getDiagnosis();
        String medicament = medicaments.getOrDefault(diagnosis, "Sorry, I have to order it");
        patient.setMedicine(medicament);
        return patient;
    }
}
