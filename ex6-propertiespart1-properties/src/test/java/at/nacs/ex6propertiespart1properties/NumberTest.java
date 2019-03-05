package at.nacs.ex6propertiespart1properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NumberTest {


    @Autowired
    Number number;
    @Test
    void getNumber() {
        Assertions.assertEquals(Integer.valueOf(369),number.getNumber());
    }
}