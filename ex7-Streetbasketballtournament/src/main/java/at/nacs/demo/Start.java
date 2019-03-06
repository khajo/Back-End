package at.nacs.demo;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedList;


@Component
@RequiredArgsConstructor
public class Start {
    private final BasketballTeamLoader basketballTeamLoader;
    private final Logic logic;

    public void tournament() {
        LinkedList<BasketballTeam> basketballTeams = basketballTeamLoader.getBasketballTeams();
        System.out.println("Welcome to the street basketball tournament!");
        System.out.println("These are the teams who signed up:");
        basketballTeams.stream().map(e -> "Team:" + e.getName() + " | " + e.getPlayers()).forEach((e -> System.out.println(e)));
        System.out.println("----------------------------------------------------------");
        logic.judge(basketballTeams);


    }


}
