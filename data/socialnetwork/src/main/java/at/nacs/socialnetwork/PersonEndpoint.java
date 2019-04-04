package at.nacs.socialnetwork;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/persons")
@RestController
@RequiredArgsConstructor
public class PersonEndpoint {


    private final PersonManager manager;

    @GetMapping
    List<Person> getAll() {
        return manager.getAll();
    }
    @GetMapping("/{id}")
    Person getByID(@PathVariable long id) {
        return manager.getpersonByID(id);
    }

    @GetMapping("/friends/with")
    List<Person> getPersonsHaveATLeastOneFriend() {
        return manager.getPersonsHaveATLeastOneFriend();
    }

    @GetMapping("/friends/without")
    List<Person> getPersonsHaveNoFriends() {
        return manager.getPersonsHaveNoFriends();
    }

    @PostMapping
    Person addPerson(@RequestBody Person person) {
        return manager.addPerson(person);
    }

    @PutMapping("/{id1}/friend/{id2}")
    void connects(@PathVariable Long id1,@PathVariable Long id2) {
        manager.connectTowPersons(id1,id2);
    //    manager.connectTowPersons(id2,id1);
    }

    @PutMapping("/{id1}/unfriend/{id2}")
    void unfriend(@PathVariable Long id1,@PathVariable  Long id2) {
        manager.unfriend(id1,id2);
    }









}
