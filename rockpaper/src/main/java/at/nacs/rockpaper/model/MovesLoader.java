package at.nacs.rockpaper.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("game")
@Getter
@Setter
public class MovesLoader {


    private List<Move> moves;

    @Bean
    List<Move> moves() {
        return moves;
    }
}


