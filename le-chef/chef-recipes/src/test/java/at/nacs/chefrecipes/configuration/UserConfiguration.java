package at.nacs.chefrecipes.configuration;


import at.nacs.chefrecipes.persistence.demo.Recipe;
import at.nacs.chefrecipes.persistence.demo.User;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("dataset3")
public class UserConfiguration {


    @Setter
    User users;


    @Bean
    User users() {
        return users;
    }
}
