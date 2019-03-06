package at.nacs.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Data
@ConfigurationProperties("names")
public class CustomerLoader {
    private List<String> customers;
}
