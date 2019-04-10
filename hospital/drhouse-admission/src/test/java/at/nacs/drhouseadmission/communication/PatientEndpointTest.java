package at.nacs.drhouseadmission.communication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {


    @Autowired
    DiagnosesClient manager;

    @Test
    void post() {
    }
}