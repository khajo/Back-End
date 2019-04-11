package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.communication.DiagnosesClient;
import at.nacs.drhouseadmission.domain.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;


@SpringBootTest(webEnvironment = NONE)
class AdmissionTest {

    @Autowired
    Admission admission;

    @MockBean
    DiagnosesClient diagnosesClient;

    private Patient patient = new Patient(null, "khajag", "headache");

    @Test
    void post() {
        Patient actual = admission.setId(patient);
        Assertions.assertThat(actual.getId()).isNotBlank();
    }
}