package at.nacs.drhousediagnoses.persistence;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
;

import java.util.Map;

@Repository
@ConfigurationProperties("direction")
public class ForwordPatient {


    @Setter
    @Getter
    private Map<String, String> directions;



}
