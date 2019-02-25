package at.nacs.ex2amazinghelloworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WorldTest {


    @Autowired
    World world;

    @Test
    void getWorld() {
        String expectede = "World";
        String actual = this.world.getWorld();
        Assertions.assertEquals(expectede,actual);
    }

}