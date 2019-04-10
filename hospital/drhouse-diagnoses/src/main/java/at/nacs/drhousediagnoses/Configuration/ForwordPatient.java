package at.nacs.drhousediagnoses.Configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@ConfigurationProperties("direction")
public class ForwordPatient {


    @Getter
    @Setter
    private Map<String, String> directions;

}
