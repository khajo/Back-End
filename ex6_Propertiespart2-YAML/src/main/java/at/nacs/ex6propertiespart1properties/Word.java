package at.nacs.ex6propertiespart1properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Word {

    @Value("${word.wordFantastic}")
    private String wordFantastic;

}
