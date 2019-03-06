package at.nacs.ex6propertiespart1properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BallerinaLoaderTest {

    @Autowired
    BallerinaLoader ballerinaLoader;


    @ParameterizedTest
    @CsvSource({
            "0,Judith,1",
            "1,Liza,4",
            "2,Nver,3",
    })
    void getBallerinas(Integer index,String name, Integer performance) {
        List<Ballerina> ballerinas = ballerinaLoader.getBallerinas();
        Ballerina ballerina = ballerinas.get(index);
        Assertions.assertEquals(name,ballerina.getName());
        Assertions.assertEquals(performance,ballerina.getPerformance());

        System.out.println(ballerinaLoader.getBallerinas());
    }
}