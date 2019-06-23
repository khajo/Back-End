package at.nacs.drhouseaccountancy.endpoint;

import at.nacs.drhouseaccountancy.logic.Invoices;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class InvoicesEndpointTest {

  @Autowired
  TestRestTemplate restTemplate;

  @MockBean
  Invoices invoices;

  String url = "/invoices";

  @Test
  void get() {
    restTemplate.getForObject(url, Invoice[].class);
    verify(invoices).findAll();
  }

  @Test
  void paid() {
    String paidUrl = url + "/1/paid";
    restTemplate.put(paidUrl, null);
    verify(invoices).markAsPaid(1L);
  }
}