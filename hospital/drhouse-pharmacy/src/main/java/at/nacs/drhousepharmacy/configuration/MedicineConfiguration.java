package at.nacs.drhousepharmacy.configuration;


import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("info")
public class MedicineConfiguration {

    @Setter
    private Map<String, String> medicines;

    @Bean
     public Map<String,String> medicaments() {
        return medicines;
    }

}
