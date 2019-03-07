package at.nacs.rockpaper.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovesLoaderTest {


    @Autowired
    MovesLoader movesLoader;
    @Test
    void getMoves() {
        System.out.println(movesLoader.getMoves());
    }
}