package at.nacs.demo;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
@Getter
@Setter
@ConfigurationProperties("names")
public class CustomerLoader {
    private List<String> customers;
}
