package at.nacs.socialnetwork;

import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ConfigurationProperties("info")
class PersonManagerTest {

    @Autowired
    PersonManager manager;

    @Autowired
    PersonRepository repository;


    @Setter
    Person person1;

    @Setter
    Person person2;

    @BeforeEach
    void before() {
        repository.save(person1);

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
    void getPersonsHaveATLeastOneFriend() {
        List<Person> personsHaveATLeastOneFriend = manager.getPersonsHaveATLeastOneFriend();
        Assertions.assertThat(personsHaveATLeastOneFriend.size()).isEqualTo(0);
    }

    @Test
    void getPersonsHaveNoFriends() {
        List<Person> personsHaveATLeastOneFriend = manager.getPersonsHaveNoFriends();
        Assertions.assertThat(personsHaveATLeastOneFriend.size()).isEqualTo(1);
    }

    @Test
    void addPerson() {
        manager.addPerson(person2);
        Assertions.assertThat(person2.getId()).isNotNull();
    }

    @Test
    void connectTowPersons() {
        Person person3 = manager.addPerson(person2);

        System.out.println(repository.findAll());
        System.out.println("Id::"+person1.getId());
        System.out.println("Id::"+person3.getId());
        manager.connectTowPersons(person3.getId(),person1.getId());
//        Assertions.assertThat(person3.getFriends().size()).isEqualTo(0);
        System.out.println("friends:: "+person3.getFriends());
        System.out.println("friends:: "+person1.getFriends());

        Assertions.assertThat(person3.getFriends().size()).isEqualTo(1);
    }

    @Test
    void unfriend() {
        Person person3 = manager.addPerson(person2);
        person1.getFriends().add(person3);
        person3.getFriends().add(person1);
        System.out.println(person1.getFriends());
        System.out.println(person3.getFriends());
        manager.unfriend(person1.getId(),person3.getId());
    }
}