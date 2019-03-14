package at.nacs.polo;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polo")
@RequiredArgsConstructor
public class PoloEndPoint {

    private final Polo polo;


    @PostMapping
    String post(@RequestBody String message) {
        return polo.getMessage(message);
    }


}
