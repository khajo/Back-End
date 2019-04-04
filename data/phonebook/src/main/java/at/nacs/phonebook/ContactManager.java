package at.nacs.phonebook;


import at.nacs.phonebook.domain.Address;
import at.nacs.phonebook.domain.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactManager {
    private final ContactRepository repository;


    List<Contact> getAll() {
        List<Contact> contacts = repository.findAll();
        return contacts;
    }

    Contact addContatct(Contact contact) {
        return repository.save(contact);
    }

    List<Contact> getContactsByAddress(String name) {
        String address = "%" + name + "%";
        return repository.findAllByAddress_NameLike(address);
    }

}
