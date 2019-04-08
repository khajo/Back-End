package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.logic.PatientManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {


    @Autowired
    PatientManager manager;

    @Test
    void post() {
    }
}