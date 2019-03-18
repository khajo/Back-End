package at.nacs.morse;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MorseEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    String url = "/morse";

    @ParameterizedTest
    @CsvSource({
            "B,-...",
            "C,-.-.",
            "9,----."
    })
    void post(String letter, String expected) {
        String getSymbol = restTemplate.postForObject(url, letter, String.class);
        assertThat(getSymbol).isEqualTo(expected);
    }


}