package at.nacs.drhousediagnoses.persistence;


import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
@ConfigurationProperties("direction")
public class ForwordPatient {


    @Setter
    @Getter
    private Map<String, String> directions;



}
