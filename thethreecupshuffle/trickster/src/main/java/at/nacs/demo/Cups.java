package at.nacs.demo;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
@ConfigurationProperties("cup")
public class Cups {

    @Getter
    @Setter
    Map<Integer,String> cupList;
}
