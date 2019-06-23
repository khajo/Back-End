package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Kind;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Invoices {

  private final Costs costs;
  private final InvoiceRepository repository;

  public Invoice invoice(Patient patient, PatientDTO patientDTO) {
    Invoice invoice = createInvoice(patient, patientDTO);
    return repository.save(invoice);
  }

  Invoice createInvoice(Patient patient, PatientDTO patientDTO) {
    return Invoice.builder()
                  .patient(patient)
                  .kind(getKind(patientDTO))
                  .symptoms(patientDTO.getSymptoms())
                  .diagnosis(patientDTO.getDiagnosis())
                  .provided(getProvided(patientDTO))
                  .cost(costs.calculate(patientDTO))
                  .paid(false)
                  .timestamp(LocalDateTime.now())
                  .build();
  }

  Kind getKind(PatientDTO patientDTO) {
    if (Strings.isNotBlank(patientDTO.getTreatment())) {
      return Kind.TREATMENT;
    }
    if (Strings.isNotBlank(patientDTO.getMedicine())) {
      return Kind.MEDICINE;
    }
    throw new IllegalStateException("Could not determine invoice kind for patient dto: " + patientDTO);
  }

  String getProvided(PatientDTO patientDTO) {
    if (getKind(patientDTO).equals(Kind.TREATMENT)) {
      return patientDTO.getTreatment();
    }
    if (getKind(patientDTO).equals(Kind.MEDICINE)) {
      return patientDTO.getMedicine();
    }
    throw new IllegalStateException("Could not determine invoice kind for patient dto: " + patientDTO);
  }

  public List<Invoice> findAll() {
    return repository.findAll();
  }

  public void markAsPaid(Long id) {
    Optional<Invoice> result = repository.findById(id);
    if (result.isEmpty()) {
      return;
    }
    Invoice invoice = result.get();
    invoice.setPaid(true);
    repository.save(invoice);
  }
}
