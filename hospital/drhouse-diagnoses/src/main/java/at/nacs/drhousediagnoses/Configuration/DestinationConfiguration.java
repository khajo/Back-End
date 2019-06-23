package at.nacs.drhousediagnoses.Configuration;


import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
@ConfigurationProperties("direction")
public class DestinationConfiguration {


    @Setter
    @Getter
    private Map<String, String> directions;



}
