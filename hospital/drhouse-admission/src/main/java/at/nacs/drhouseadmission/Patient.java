package at.nacs.drhouseadmission;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Patient {

    private String id;
    private String name;
    private String symptoms;

}
