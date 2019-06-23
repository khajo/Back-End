package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class Patients {

    private final PatientRepository patientRepository;

    public Patient findOrCreate(PatientDTO patientDTO) {
        Optional<Patient> patient = findOneByUuid(patientDTO);
        if (patient.isPresent()) {
            return patient.get();
        }
        patient = findOneByName(patientDTO);
        if (patient.isPresent()) {
            return patient.get();
        }
        return createPatient(patientDTO);
    }

    private Optional<Patient> findOneByUuid(PatientDTO patientDTO) {
        String uuid = patientDTO.getId();
        return patientRepository.findOneByUuid(uuid);
    }

    private Optional<Patient> findOneByName(PatientDTO patientDTO) {
        String name = patientDTO.getName();
        return patientRepository.findOneByName(name);
    }

    private Patient createPatient(PatientDTO patientDTO) {
        Patient patient = Patient.builder()
                .name(patientDTO.getName())
                .uuid(patientDTO.getId())
                .build();
        patientRepository.save(patient);
        return patient;
    }

}
