package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.persistence.Patient;
import at.nacs.drhousepharmacy.persistence.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PharmacyManager {
    private final PharmacyRepository repository;
    private final Apothecary apothecary;

    public Patient add(Patient patient) {
        apothecary.giveMedicament(patient);
        return repository.save(patient);
    }


}
