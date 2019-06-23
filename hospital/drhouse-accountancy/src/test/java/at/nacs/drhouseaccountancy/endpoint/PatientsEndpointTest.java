package at.nacs.drhouseaccountancy.endpoint;

import at.nacs.drhouseaccountancy.communication.dto.PatientDTO;
import at.nacs.drhouseaccountancy.logic.Accountancy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {

  @Autowired
  TestRestTemplate restTemplate;

  @MockBean
  Accountancy accountancy;

  @Autowired
  PatientDTO patientDtoTreatment;

  String url = "/patients";

  @Test
  void post() {
    restTemplate.postForObject(url, patientDtoTreatment, PatientDTO.class);

    verify(accountancy).invoice(patientDtoTreatment);
  }
}