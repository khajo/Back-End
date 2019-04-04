package at.nacs.socialnetwork;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonManager {

    private final PersonRepository repository;

    List<Person> getAll() {
        return repository.findAll();
    }

    List<Person> getPersonsHaveATLeastOneFriend() {
        List<Person> persons = getAll();
        return persons.stream()
                .filter(e -> e.getFriends().size() >= 1)
                .collect(Collectors.toList());
    }

    List<Person> getPersonsHaveNoFriends() {
        return repository.findAllByFriends_Empty();
    }

    Person addPerson(Person person) {
        return repository.save(person);
    }

    Person getpersonByID(Long id) {
        return repository.findById(id).orElse(null);
    }

    void connectTowPersons(Long id1, Long id2) {
        Person person1 = getpersonByID(id1);
        Person person2 = getpersonByID(id2);
        person1.getFriends().add(person2);
        person2.getFriends().add(person1);
        repository.save(person1);
        repository.save(person2);


        System.out.println("add friend in main App");
    }


    void unfriend(Long id1, Long id2) {
        Person person1 = getpersonByID(id1);
        Person person2 = getpersonByID(id2);
        person1.getFriends().remove(person2);
        repository.save(person1);
        repository.save(person2);

    }


}
