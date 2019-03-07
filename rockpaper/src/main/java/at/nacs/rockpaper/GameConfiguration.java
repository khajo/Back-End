package at.nacs.rockpaper;

import at.nacs.rockpaper.controller.Game;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

    @Bean
    ApplicationRunner runner(Game game) {
        return args -> {
            game.play();
        };
    }


}
