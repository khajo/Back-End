package at.nacs.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Random;


@Component
@RequiredArgsConstructor
public class Logic {


    private Random random = new Random();

    public BasketballTeam judge(LinkedList<BasketballTeam> basketballTeams) {
        while (basketballTeams.size() > 1) {
            BasketballTeam winner = getWinner(basketballTeams);
            System.out.println(winner.getName() + " wins this match!");
            basketballTeams.offer(winner);
        }

        return basketballTeams.poll();
    }


    public BasketballTeam getWinner(LinkedList<BasketballTeam> basketballTeams) {
        BasketballTeam firstTEam = basketballTeams.poll();
        BasketballTeam secoundTeam = basketballTeams.poll();
        boolean judge = random.nextBoolean();
        System.out.println(firstTEam.getName() + " plays vs " + secoundTeam.getName());
        if (judge == true) {
            return firstTEam;
        }
        return secoundTeam;
    }
}
