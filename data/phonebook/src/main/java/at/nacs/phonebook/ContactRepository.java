package at.nacs.phonebook;

import at.nacs.phonebook.domain.Address;
import at.nacs.phonebook.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAllByAddress_NameLike(String address);
}
