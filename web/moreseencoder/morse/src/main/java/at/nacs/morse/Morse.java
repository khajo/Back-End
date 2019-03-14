package at.nacs.morse;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;



@Configuration
@ConfigurationProperties("administration")
public class Morse {


    @Setter
    private  Map<String, String> morseMap;


    @Bean
    ApplicationRunner

}

public class CustomersInitializer {


    @Bean
    ApplicationRunner initialize(CustomersRepository customersRepository) {
        return args -> customers.stream()
                .forEach(customersRepository::add);
    }

}

