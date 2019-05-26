package at.nacs.chefrecipes.configuration;


import at.nacs.chefrecipes.persistence.data.User;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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
