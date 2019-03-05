package at.nacs.ex6propertiespart1properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties("shop")
@Getter
@Setter
public class BookShop {

    private Map<String, Integer> books;
}
