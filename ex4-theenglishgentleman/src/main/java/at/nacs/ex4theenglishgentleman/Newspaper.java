package at.nacs.ex4theenglishgentleman;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
@Data
public class Newspaper {
}
