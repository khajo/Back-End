package at.nacs.morse;



import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Map;



@Configuration
@ConfigurationProperties("code")
public class MorseConfiguration {


    @Setter
    private  Map<String, String> morseMap;


    @Bean
    Map<String, String> morseMap() {
        return morseMap;
    }

}



