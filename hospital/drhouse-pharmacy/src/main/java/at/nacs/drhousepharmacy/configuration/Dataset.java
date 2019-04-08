package at.nacs.drhousepharmacy.configuration;


import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("info")
public class Dataset {

    @Setter
    private Map<String, String> medicaments;

    @Bean
     public Map<String,String> medicaments() {
        return medicaments;
    }

}
