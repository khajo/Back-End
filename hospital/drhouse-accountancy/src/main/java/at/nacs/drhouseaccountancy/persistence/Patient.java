package at.nacs.drhouseaccountancy.persistence;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue
    private Long id;

    private String uuid; //(id that arrived from the DTO)

    @Column(unique = true)
    private String name; //(unique)

}
