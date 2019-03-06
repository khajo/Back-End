package at.nacs.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


import java.util.LinkedList;


@Component
@Getter
@Setter
@ConfigurationProperties("team")
public class BasketballTeamLoader {

    private LinkedList<BasketballTeam> basketballTeams;
}
