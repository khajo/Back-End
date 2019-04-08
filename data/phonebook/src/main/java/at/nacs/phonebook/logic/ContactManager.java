package at.nacs.phonebook.logic;


import at.nacs.phonebook.persistence.ContactRepository;
import at.nacs.phonebook.persistence.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactManager {

    private final ContactRepository repository;

   public List<Contact> findAll() {
        return repository.findAll();
    }

   public Contact addContatct(Contact contact) {
        return repository.save(contact);
    }

   public List<Contact> findBy(String name) {
        String address = "%" + name + "%";
        return repository.findAllByAddressNameLike(address);
    }

}
