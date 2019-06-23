package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.communication.client.AccountancyClient;
import at.nacs.drhousepharmacy.persistence.domain.Patient;
import at.nacs.drhousepharmacy.persistence.repository.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PharmacyManager {
    private final PharmacyRepository repository;
    private final AccountancyClient accountancyClient;

    public Patient post(Patient patient) {
        Patient patientByPharmacy = repository.save(patient);
        return accountancyClient.post(patientByPharmacy);
    }


}
