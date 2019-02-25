package at.nacs.ex2amazinghelloworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloTest {

    @Autowired
    Hello hello;


    @Test
    void getHallo() {
        String expected = "Hello";

        String actual = hello.getHallo();
        Assertions.assertEquals(expected,actual);

    }
}