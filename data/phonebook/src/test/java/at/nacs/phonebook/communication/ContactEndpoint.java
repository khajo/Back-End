package at.nacs.phonebook.communication;

import at.nacs.phonebook.persistence.Contact;
import at.nacs.phonebook.logic.ContactManager;
import at.nacs.phonebook.persistence.ContactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ContactEndpoint {

    private String url = "/contacts";

    @Autowired
    TestRestTemplate restTemplate;


    @MockBean
    ContactRepository repository;

    @SpyBean
    ContactManager manager;


    @Autowired
    List<Contact> contacts;


    @Test
    void getAll() {
        restTemplate.getForObject(url, Contact[].class);
        verify(manager).findAll();
    }

    @Test
    void add() {
        Contact contact = contacts.get(0);
        restTemplate.postForObject(url, contact, Contact.class);
     //   verify(manager).addContatct(Mockito.any());
        verify(manager).addContatct(contact);
    }

    @Test
    void getByID() {
        String address = "some-address";
        String getByAddressURL = url + "/address/" + address;

        restTemplate.getForObject(getByAddressURL, Contact[].class);

       // verify(manager).findBy(anyString());
        verify(manager).findBy(address);
    }
}