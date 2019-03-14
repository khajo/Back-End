package at.nacs.morse;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MorseTest {

    @Autowired
    Morse morse;

    @Test
    void getMorseMap() {

        System.out.println(morse.getMorseMap());
    }
}