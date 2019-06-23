package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.repository.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class PatientsTest {

  @Autowired
  Patients patients;

  @Autowired
  PatientDTO patientDtoTreatment;

  @Autowired
  Patient patient;

  @Autowired
  PatientRepository repository;

  @BeforeEach
  void before() {
    patient.setId(null);
  }

  @AfterEach
  void after() {
    Optional<Patient> oPatient = repository.findOneByUuid(patient.getUuid());
    oPatient.ifPresent(repository::delete);
  }

  @Test
  void findOrCreateFinds() {
    Patient saved = repository.save(patient);

    Patient actual = patients.findOrCreate(patientDtoTreatment);

    assertThat(actual.getId()).isEqualTo(saved.getId());
    assertThat(actual.getUuid()).isEqualTo(saved.getUuid());
    assertThat(actual.getName()).isEqualTo(saved.getName());
  }

  @Test
  void findOrCreateCreates() {
    Patient actual = patients.findOrCreate(patientDtoTreatment);

    assertThat(actual.getId()).isNotNull();
    assertThat(actual.getUuid()).isEqualTo(patientDtoTreatment.getId());
    assertThat(actual.getName()).isEqualTo(patientDtoTreatment.getName());

    boolean exists = repository.existsById(actual.getId());
    assertThat(exists).isTrue();
  }
}