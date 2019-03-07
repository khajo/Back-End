package at.nacs.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TemplateEngine {

    private final List<Template> templates;


    public String getText(String name) {
        return templates.stream()
                .filter(e -> name.contains(e.getTitle()))
                .map(e -> e.getText())
                .map(e -> e.replace("name", name))
                .findFirst().orElse("Invalid");


    }
}
