package at.nacs.drhousebed.configuration;


import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Map;

@Setter
@ConfigurationProperties("info")
@Configuration
public class Treatment {


    private Map<String, String> treatments;

    @Bean
    Map<String, String> treatments() {
        return treatments;
    }

}
