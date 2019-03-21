package at.nacs.fengshuiapi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("symbol")
public class Signs {


    @Getter
    @Setter
    private Map<String, String> signMap;

}
