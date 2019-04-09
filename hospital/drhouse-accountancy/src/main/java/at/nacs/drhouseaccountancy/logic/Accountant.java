package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Accountant {

    private final Map<String, Double> prices;
    private final PatientRepository patientRepository;
    private final InvoiceRepository invoiceRepository;


    public PatientDTO store(PatientDTO patientDTO) {
        Patient patient = Patient.builder()
                .uuid(patientDTO.getId())
                .name(patientDTO.getName())
                .build();

        Invoice invoice = Invoice.builder()
                .patient(patient)
                .kind(getKind(patientDTO))
                .symptoms(patientDTO.getSymptoms())
                .diagnosis(patientDTO.getDiagnosis())
                .provided(getProvided(patientDTO))
                .cost(getCost(patientDTO))
                .paid(false)
                .timestamp(LocalDateTime.now())
                .build();
        patientRepository.save(patient);
        invoiceRepository.save(invoice);
        return patientDTO;

    }

    public List<Invoice> invoices() {
        return invoiceRepository.findAll();
    }

    public void setAspaid(Long id) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
        if (optionalInvoice.isEmpty()) {
            return;
        }
        optionalInvoice.get().setPaid(true);
        invoiceRepository.save(optionalInvoice.get());

    }


    private Kind getKind(PatientDTO patientDTO) {
        if (getProvided(patientDTO).equals("medicine")) {
            return Kind.MEDICINE;
        }
        return Kind.TREATMENT;
    }


    public String getProvided(PatientDTO patientDTO) {
        if (Objects.equals(patientDTO.getMedicine(),null)) {
            return "treatment";
        }
        return "medicine";
    }

    private double getCost(PatientDTO patientDTO) {
        if (getProvided(patientDTO).equals("medicine")) {
            return getMedicineCost(patientDTO);
        }
        return getTreatmentCost(patientDTO);
    }

    private Double getMedicineCost(PatientDTO patientDTO) throws IllegalArgumentException{
        String medicine = patientDTO.getMedicine();
        return prices.getOrDefault(medicine, null);

    }

    private Double getTreatmentCost(PatientDTO patientDTO) {
        String treatment = patientDTO.getTreatment();
        return prices.getOrDefault(treatment, null);

    }


}
