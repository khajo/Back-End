package at.nacs.ex6propertiespart1properties;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("place")
public class Sauna {

    private Integer availableSeats;
    private Integer temperature;
}
