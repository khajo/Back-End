package at.nacs.drhousebed;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BedManeger {

    private final BedRepository repository;
    private final Nurse nurse;


    public Patient add(Patient patient) {
            String diagnosis = patient.getDiagnosis();
            String treat = nurse.treat(diagnosis);
        patient.setTreatment(treat);
       repository.save(patient);
        return patient;

    }




}
