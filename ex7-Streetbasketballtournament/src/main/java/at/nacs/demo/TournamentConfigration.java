package at.nacs.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TournamentConfigration {


    @Bean
    ApplicationRunner TournamentApp(Start start) {
        return args -> {

            start.tournament();
        };

    }
}
