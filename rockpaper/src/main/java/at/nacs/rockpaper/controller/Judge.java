package at.nacs.rockpaper.controller;

import at.nacs.rockpaper.model.Move;
import org.springframework.stereotype.Component;

@Component
public class Judge {

    public String decideWinner(Move move1, Move move2) {
        if (move1.getDefeats().contains(move2.getName())) {
            return "Player1 wins !";
        }
        if (move2.getDefeats().contains(move1.getName())) {
            return "Player2 wins !";

        }
        return "No Winner!";
    }

}
