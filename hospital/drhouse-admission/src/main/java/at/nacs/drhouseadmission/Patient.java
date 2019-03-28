package at.nacs.drhouseadmission;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    private String id;
    private String name;
    private String symptoms;

}
