package at.nacs.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TemplateEngineTest {

    @Autowired
    TemplateEngine templateEngine;

    @Test
    void getText() {

       System.out.println(templateEngine.getText(" "));

    }
}