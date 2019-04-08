package at.nacs.drhouseadmission.domain;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    private String id;
    private String name;
    private String symptoms;

}
