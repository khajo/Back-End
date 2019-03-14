package at.nacs.jacksparrow;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deadmanschest")
@RequiredArgsConstructor
public class JacksparrowEndPoint {

    private final tiadalmaClient tiadalmaClient;

    @GetMapping("/hi")
    String get() {
        return tiadalmaClient.get();
    }

    @GetMapping("/item")
    String getItem() {
        return tiadalmaClient.getItem();
    }

}
