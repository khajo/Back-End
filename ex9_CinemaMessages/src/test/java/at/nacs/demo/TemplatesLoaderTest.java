package at.nacs.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TemplatesLoaderTest {


    @Autowired
    TemplatesConfiguration templatesConfiguration;


    @Test
    void getTemplates() {
        System.out.println(templatesConfiguration);
    }
}