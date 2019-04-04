package at.nacs.phonebook;

import at.nacs.phonebook.domain.Contact;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ConfigurationProperties("info")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PhoneBookEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;


    @MockBean
    ContactRepository repository;

    @SpyBean
    ContactManager manager;

    private String url = "/contacts";

    @Setter
    Contact contact1;


    @Test
    void getAll() {
        restTemplate.getForObject(url, Contact[].class);
        verify(manager).getAll();
    }

    @Test
    void add() {
        restTemplate.postForObject(url, contact1, Contact.class);
        verify(manager).addContatct(Mockito.any());
    }

    @Test
    void getByID() {
        restTemplate.getForObject(url+"/address/1234", Contact[].class);
        verify(manager).getContactsByAddress(anyString());

    }
}