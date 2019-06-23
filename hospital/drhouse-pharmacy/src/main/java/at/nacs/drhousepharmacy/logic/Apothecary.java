package at.nacs.drhousepharmacy.logic;


import at.nacs.drhousepharmacy.persistence.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class Apothecary {
    private final Map<String, String> medicines;

    public Patient giveMedicament(Patient patient) {
        String diagnosis = patient.getDiagnosis();
        String medicament = medicines.getOrDefault(diagnosis, "Sorry, I have to order it");
        patient.setMedicine(medicament);
        return patient;
    }
}
