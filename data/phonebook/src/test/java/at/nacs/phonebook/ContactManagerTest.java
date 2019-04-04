package at.nacs.phonebook;

import at.nacs.phonebook.domain.Contact;
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
@ConfigurationProperties("info")
class ContactManagerTest {

    @Autowired
    ContactRepository repository;

    @Autowired
    ContactManager manager;

    @Setter
    Contact contact1;

    @Setter
    Contact contact2;

    @Setter
    Contact contact3;
    @BeforeEach
    void before() {
        repository.save(contact1);
    }

    @AfterEach
    void after() {
        repository.deleteAll();
    }

    @Test
    void getAll() {
        int size = manager.getAll().size();
        Assertions.assertThat(size).isEqualTo(1);
    }

    @Test
    void addContatct() {

        Contact actual = manager.addContatct(contact2);
        Assertions.assertThat(actual.getId()).isNotNull();
    }

    @Test
    void getContactsByAddress() {
      manager.addContatct(contact3);
        List<Contact> contactsByAddress = manager.getContactsByAddress("12345");
        Assertions.assertThat(contactsByAddress.size()).isEqualTo(1);


    }
}