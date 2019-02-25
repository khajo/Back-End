package at.nacs.ex3thecursedcoin;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component

public class JackSparrow {

    private LegendaryCompass legendaryCompass;

    public JackSparrow(LegendaryCompass legendaryCompass) {
        this.legendaryCompass = legendaryCompass;
    }




    public String findCursedCoin() {
        return "I found the " + legendaryCompass.getCoinName() + "!";
    }
}
