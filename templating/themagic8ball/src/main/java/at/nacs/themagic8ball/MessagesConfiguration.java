package at.nacs.themagic8ball;


import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("info")
public class MessagesConfiguration {

    @Setter
    private List<String> messages;

    @Bean
    List<String> messages() {
        return messages;
    }
}
