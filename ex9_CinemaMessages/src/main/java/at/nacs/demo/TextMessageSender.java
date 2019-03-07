package at.nacs.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TextMessageSender {
    private final CustomerLoader customerLoader;
    private final TemplateEngine templateEngine;


    public List<String> getMessages() {
        return customerLoader.getCustomers().stream()
                .map(e -> templateEngine.getText(e))
                .collect(Collectors.toList());
    }


}
