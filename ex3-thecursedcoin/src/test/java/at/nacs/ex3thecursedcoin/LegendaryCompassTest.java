package at.nacs.ex3thecursedcoin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LegendaryCompassTest {

    @Autowired
    LegendaryCompass legendaryCompass;


    @Test
    void getCoinName() {
        String expected = "CursedCoin";
        String actual = legendaryCompass.getCoinName();
        Assertions.assertEquals(expected,actual);
    }
}