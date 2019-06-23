package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AccountancyTest {

  @Autowired
  Accountancy accountancy;

  @MockBean
  Patients patients;

  @MockBean
  Invoices invoices;

  @Autowired
  PatientDTO patientDtoTreatment;

  @Test
  void invoice() {
    when(patients.findOrCreate(patientDtoTreatment)).thenReturn(new Patient());

    accountancy.invoice(patientDtoTreatment);

    verify(patients).findOrCreate(patientDtoTreatment);
    verify(invoices).invoice(any(Patient.class), any(PatientDTO.class));
  }
}