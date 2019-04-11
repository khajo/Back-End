package at.nacs.drhousediagnoses.communication;

import at.nacs.drhousediagnoses.logic.DiagnosesManager;
import at.nacs.drhousediagnoses.persistence.Patient;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;


import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;


@SpringBootTest(webEnvironment = RANDOM_PORT)
class DiagnosesEndpointTest {


    @Autowired
    TestRestTemplate testRestTemplate;

    @SpyBean
    DiagnosesManager manager;


    @MockBean
    BedClient bedClient;

    @MockBean
    PharmacyClient pharmacyClient;


    private String url = "/patients";
    private Patient patient = new Patient();


    @ParameterizedTest
    @CsvSource({
            "headache",
            "Highfever",
            "stuffynose",
            "Shortnessofbreath"
    }
    )
    void post(String symptoms) {
        patient.setSymptoms(symptoms);
        testRestTemplate.postForObject(url, patient, Patient.class);
        Mockito.verify(manager).post(Mockito.any());
    }
}