package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Kind;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.repository.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistence.repository.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class InvoicesTest {

  @Autowired
  Invoices invoices;

  @Autowired
  InvoiceRepository invoiceRepository;

  @Autowired
  PatientRepository patientRepository;

  @Autowired
  Invoice invoiceTreatment;

  @Autowired
  Invoice invoiceMedicine;

  @Autowired
  PatientDTO patientDtoTreatment;

  @Autowired
  PatientDTO patientDtoMedicine;

  @Autowired
  Patient patient;

  @BeforeEach
  void before() {
    patientRepository.save(patient);
    invoiceTreatment.setPatient(patient);
    invoiceMedicine.setPatient(patient);
    invoiceRepository.save(invoiceTreatment);
    invoiceRepository.save(invoiceMedicine);
  }

  @AfterEach
  void after() {
    invoiceRepository.deleteAll();
    patientRepository.deleteAll();
    patient.setId(null);
    invoiceTreatment.setId(null);
    invoiceTreatment.getPatient().setId(null);
    invoiceMedicine.setId(null);
    invoiceMedicine.getPatient().setId(null);
  }

  @Test
  void createInvoice() {
    patientInvoices().entrySet().stream()
                     .forEach(e -> {
                       PatientDTO patientDTO = e.getKey();
                       Invoice invoice = e.getValue();
                       Invoice actual = invoices.createInvoice(patient, patientDTO);
                       assertThat(actual).isEqualToIgnoringGivenFields(invoice, "id", "timestamp");
                       assertThat(actual.getId()).isNull();
                       assertThat(actual.getTimestamp()).isNotNull();
                     });
  }

  private Map<PatientDTO, Invoice> patientInvoices() {
    return Map.of(
        patientDtoTreatment, invoiceTreatment,
        patientDtoMedicine, invoiceMedicine);
  }

  @Test
  void getKindSucceeds() {
    patientInvoices().entrySet().stream()
                     .forEach(e -> {
                       PatientDTO patientDTO = e.getKey();
                       Invoice invoice = e.getValue();
                       Kind kind = invoices.getKind(patientDTO);
                       assertThat(kind).isEqualTo(invoice.getKind());
                     });
  }

  @Test
  void getKindFails() {
    PatientDTO emptyPatient = new PatientDTO();
    assertThrows(IllegalStateException.class, () -> invoices.getKind(emptyPatient));
  }

  @Test
  void getProvidedSucceeds() {
    patientInvoices().entrySet().stream()
                     .forEach(e -> {
                       PatientDTO patientDTO = e.getKey();
                       Invoice invoice = e.getValue();
                       String provided = invoices.getProvided(patientDTO);
                       assertThat(provided).isEqualTo(invoice.getProvided());
                     });
  }

  @Test
  void getProvidedFails() {
    PatientDTO emptyPatient = new PatientDTO();
    assertThrows(IllegalStateException.class, () -> invoices.getProvided(emptyPatient));
  }

  @Test
  void findAll() {
    List<Invoice> all = invoices.findAll();
    assertThat(all.size()).isEqualTo(2);
  }

  @Test
  void markAsPaid() {
    assertThat(invoiceTreatment.isPaid()).isFalse();

    Long id = invoiceTreatment.getId();
    invoices.markAsPaid(id);

    Invoice actual = invoiceRepository.findById(id).get();
    assertThat(actual.isPaid()).isTrue();
  }
}