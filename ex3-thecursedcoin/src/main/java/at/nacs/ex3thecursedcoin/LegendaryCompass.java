package at.nacs.ex3thecursedcoin;


import org.springframework.stereotype.Component;

@Component

public class LegendaryCompass {


    private CursedCoin cursedCoin;

    public LegendaryCompass(CursedCoin cursedCoin) {
        this.cursedCoin = cursedCoin;
    }

    public String getCoinName() {
        return cursedCoin.getClass().getSimpleName();
    }

}
