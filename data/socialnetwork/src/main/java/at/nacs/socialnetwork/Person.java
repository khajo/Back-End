package at.nacs.socialnetwork;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@EqualsAndHashCode(exclude = "friends")
public class Person {


    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = EAGER)
    private List<Person> friends = new ArrayList<>();

//    @Override
//    public String toString() {
//        return  friends.stream().map(e->e.getName()).collect(Collectors.joining());
//    }

//    @Override
//    public String toString() {
//        return ""+ friends+"";
//    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
