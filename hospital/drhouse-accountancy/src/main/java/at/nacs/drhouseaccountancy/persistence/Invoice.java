package at.nacs.drhouseaccountancy.persistence;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Patient patient; //(many to one)

    @Enumerated(EnumType.STRING)
    private Kind kind; //(enum)
    private String symptoms;
    private String diagnosis;
    private String provided;// (either the treatment given or the medicine suggested)
    private double cost;
    private boolean paid;
    private LocalDateTime timestamp;

    public Invoice() {
    }
}
