package at.nacs.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogicTest {

    @Autowired
    Logic logic;
    @Autowired
    BasketballTeamLoader basketballTeamLoader;


    @Test
    void tournament() {
        System.out.println(logic.judge(basketballTeamLoader.getBasketballTeams()));
    }
}