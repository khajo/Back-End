package at.nacs.ex6propertiespart1properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Number {

    @Getter
    @Value("${number.number}")
    private Integer number;
}
