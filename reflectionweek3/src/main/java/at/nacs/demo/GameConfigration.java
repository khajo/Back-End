package at.nacs.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

public class GameConfigration {
    @Bean
    ApplicationRunner runner(Transformer transformer) {
        return args -> {
            System.out.println(transformer.gethandShakes());
        };
    }

}
