package at.nacs.ex6propertiespart1properties;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WordTest {

    @Autowired
    Word wordFantastic;

    @Test
    void getWord() {
        Assertions.assertEquals("word fantastic",wordFantastic.getWordFantastic());
    }
}