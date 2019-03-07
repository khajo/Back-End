package at.nacs.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@ConfigurationProperties("text")
public class TemplatesConfiguration {

    @Setter
    private List<Template> templates;

    @Bean
    List<Template> templates() {
        return templates;
    }
}
