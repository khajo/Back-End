package at.nacs.phonebook.logic;

import at.nacs.phonebook.persistence.Contact;
import at.nacs.phonebook.logic.ContactManager;
import at.nacs.phonebook.persistence.ContactRepository;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import java.util.List;


@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class ContactManagerTest {

    @Autowired
    ContactRepository repository;

    @Autowired
    ContactManager manager;

    @Autowired
    List<Contact> contacts;

    @BeforeEach
    void before() {
        repository.save(contacts.get(0));
    }

    @AfterEach
    void after() {
        repository.deleteAll();
    }

    @Test
    void getAll() {
        int size = manager.findAll().size();
        Assertions.assertThat(size).isEqualTo(1);
    }

    @Test
    void addContatct() {

        Contact actual = manager.addContatct(contacts.get(1));
        Assertions.assertThat(actual.getId()).isNotNull();
    }

    @Test
    void getContactsByAddress() {
      manager.addContatct(contacts.get(1));
        List<Contact> contactsByAddress = manager.findBy("Fake address");
        Assertions.assertThat(contactsByAddress.size()).isEqualTo(1);


    }
}