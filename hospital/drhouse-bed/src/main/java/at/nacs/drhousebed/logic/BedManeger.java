package at.nacs.drhousebed.logic;


import at.nacs.drhousebed.persistence.BedRepository;
import at.nacs.drhousebed.persistence.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BedManeger {

    private final BedRepository repository;


    public Patient add(Patient patient) {
        return repository.save(patient);
    }


}
