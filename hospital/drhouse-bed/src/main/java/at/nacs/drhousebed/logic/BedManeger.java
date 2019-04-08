package at.nacs.drhousebed.logic;


import at.nacs.drhousebed.persistence.BedRepository;
import at.nacs.drhousebed.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BedManeger {

    private final BedRepository repository;
    private final Nurse nurse;


    public Patient add(Patient patient) {
        Patient patientafterTreatment = nurse.treat(patient);
        return repository.save(patientafterTreatment);
    }


}
