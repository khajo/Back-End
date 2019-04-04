package at.nacs.phonebook.domain;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Contact {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToOne(cascade=CascadeType.ALL)
    private Address address;

}
