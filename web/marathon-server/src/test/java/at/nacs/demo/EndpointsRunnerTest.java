package at.nacs.demo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class EndpointsRunnerTest {

    @Autowired
    TestRestTemplate restTemplate;


    String url = "/runners";

    @ParameterizedTest
    @CsvSource({
            "khajag,PT15M",
            "Apig,PT5M"
    })
    void getRunners(String name, Duration time) {
        List<Runner> runners = Arrays.asList(Runner.builder().name(name).time(time).build());


    }

    @Test
    void postRunner() {
    }
}