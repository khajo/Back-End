package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.communication.client.DiagnosesClient;
import at.nacs.drhouseadmission.communication.dto.Patient;


import at.nacs.drhouseadmission.logic.Admission;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {


    @Autowired
    TestRestTemplate testRestTemplate;

    @SpyBean
    Admission admission;

    @MockBean
    DiagnosesClient diagnosesClient;


    private String url = "/patients";

    private Patient patient = new Patient();

    @Test
    void post() {
        testRestTemplate.postForObject(url, patient, Patient.class);
        Mockito.verify(admission).setId(Mockito.any());


    }
}