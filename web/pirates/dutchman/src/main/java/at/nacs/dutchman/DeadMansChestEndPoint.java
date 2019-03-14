package at.nacs.dutchman;


import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deadmanschest")
public class DeadMansChestEndPoint {

    private String item = "Hallo";


    @GetMapping
    String get() {
        return item;
    }
}
