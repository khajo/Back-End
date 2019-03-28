package at.nacs.drhousebed;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;


import java.util.Map;

@Repository
@ConfigurationProperties("info")
public class Treatment {

    @Setter
    @Getter
    private Map<String, String> treatments;

//    @Bean
//    Map<String, String> treatments() {
//        return treatments;
//    }

}
