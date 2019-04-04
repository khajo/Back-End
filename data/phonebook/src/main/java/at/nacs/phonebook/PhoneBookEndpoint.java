package at.nacs.phonebook;


import at.nacs.phonebook.domain.Address;
import at.nacs.phonebook.domain.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/contacts")
@RequiredArgsConstructor
@RestController
public class PhoneBookEndpoint {
    private final ContactManager manager;


    @GetMapping
    List<Contact> getAll() {
        return manager.getAll();
    }


    @PostMapping
    Contact add(@RequestBody Contact contact) {
        return manager.addContatct(contact);
    }

    @GetMapping("/address/{address}")
    List<Contact> getByID(@PathVariable String address) {
        return manager.getContactsByAddress(address);
    }

}
