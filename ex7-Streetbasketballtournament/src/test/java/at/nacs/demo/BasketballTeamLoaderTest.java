package at.nacs.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BasketballTeamLoaderTest {

    @Autowired
    BasketballTeamLoader team;

    @Test
    void getBasketballTeams() {

        System.out.println(team.getBasketballTeams());

    }
}