package at.nacs.drhousediagnoses.Configuration;


import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Map;

@Configuration
@ConfigurationProperties("dataset")
public class DiagnosisConfiguration {

    @Setter
    private Map<String, String> diagnosis;

    @Bean
    Map<String,String> diagnosisList() {
        return diagnosis;
    }



}
