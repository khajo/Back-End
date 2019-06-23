package at.nacs.drhouseaccountancy.configuration;


import at.nacs.drhouseaccountancy.persistence.domain.Price;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@ConfigurationProperties("accountancy")
public class CostsConfiguration {

    @Setter
    private List<Price> prices;

    @Bean
    Map<String, Double> prices() {
        return prices.stream()
                .collect(Collectors.toMap(Price::getProvided, Price::getPrice));
    }

}
