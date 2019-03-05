package at.nacs.ex6propertiespart1properties;

import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Value
@ConfigurationProperties("suan")
public class Sauna {

    private Integer availableSeats;
    private Integer temperature;
}
