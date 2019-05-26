package at.nacs.chefrecipes.configuration;


import at.nacs.chefrecipes.persistence.demo.Recipe;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("dataset")
public class RecipesConfiguration {


    @Setter
    List<Recipe> recipes;


    @Bean
    List<Recipe> recipes() {
        return recipes;
    }
}
