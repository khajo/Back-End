package at.nacs.ex6propertiespart1properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SaunaTest {


    @Autowired
    Sauna sauna;

    @Test
    void getAvailableSeats() {
        System.out.println(sauna.getAvailableSeats());
    }

    @Test
    void getTemperature() {
        System.out.println(sauna.getTemperature());
    }
}