package at.nacs.drhousebed.logic;


import at.nacs.drhousebed.communication.client.AccountancyClient;
import at.nacs.drhousebed.persistence.repository.BedRepository;
import at.nacs.drhousebed.persistence.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BedManeger {

    private final BedRepository repository;
    private final AccountancyClient accountancyClient;


    public Patient post(Patient patient) {
        Patient patientInBed = repository.save(patient);
        return accountancyClient.post(patientInBed);
    }


}
