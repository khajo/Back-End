package at.nacs.chefrecipes.configuration;


import at.nacs.chefrecipes.persistence.data.Kitchen;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@ConfigurationProperties("dataset2")
@Configuration
public class KitchenConfiguration {


    @Setter
    private List<Kitchen> kitchens;

    @Bean
    List<Kitchen> kitchens() {
        return kitchens;
    }


}
