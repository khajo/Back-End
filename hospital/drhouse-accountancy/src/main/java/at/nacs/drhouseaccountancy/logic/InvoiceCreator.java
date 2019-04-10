package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.Kind;
import at.nacs.drhouseaccountancy.persistence.Patient;
import at.nacs.drhouseaccountancy.persistence.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class InvoiceCreator {

    private final PatientCreator patientCreator;


    public Invoice getInvoice(PatientDTO patientDTO, double cost) {
        Patient patient = patientCreator.getPatient(patientDTO);
        return Invoice.builder()
                .patient(patient)
                .kind(getKind(patientDTO))
                .symptoms(patientDTO.getSymptoms())
                .diagnosis(patientDTO.getDiagnosis())
                .provided(getProvided(patientDTO))
                .cost(cost)
                .paid(false)
                .timestamp(LocalDateTime.now())
                .build();
    }

    private Kind getKind(PatientDTO patientDTO) {
        if (getProvided(patientDTO).equals("medicine")) {
            return Kind.MEDICINE;
        }
        return Kind.TREATMENT;
    }

    private String getProvided(PatientDTO patientDTO) {
        if (Objects.equals(patientDTO.getMedicine(), null)) {
            return "treatment";
        }
        return "medicine";
    }

}
