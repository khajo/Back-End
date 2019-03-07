package at.nacs.ex6propertiespart1properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SaunaTest {


    @Autowired
    Sauna sauna;

    @Test
    void getAvailableSeats() {


    }

    @Test
    void getTemperature() {

    }
}