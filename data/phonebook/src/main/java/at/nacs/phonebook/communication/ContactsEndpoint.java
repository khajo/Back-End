package at.nacs.phonebook.communication;


import at.nacs.phonebook.logic.ContactManager;
import at.nacs.phonebook.persistence.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/contacts")
@RequiredArgsConstructor
@RestController
public class ContactsEndpoint {
    private final ContactManager manager;


    @GetMapping
    List<Contact> getAll() {
        return manager.findAll();
    }


    @PostMapping
    Contact add(@RequestBody Contact contact) {
        return manager.addContatct(contact);
    }

    @GetMapping("/address/{address}")
    List<Contact> getByID(@PathVariable String address) {
        return manager.findBy(address);
    }

}
