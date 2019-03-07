package at.nacs.demo;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;


@Setter
@ConfigurationProperties("moves")
@Configuration
public class MovesConfiguration {
   private Map<Integer, String> moves;

    @Bean
    Map<Integer, String> getMoves() {
        return moves;
    }
}
