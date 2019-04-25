package at.nacs.example;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class MessageEndpoint {


    @GetMapping
    String message() {
        return "Hello there everyone";
    }
}
