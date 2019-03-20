package at.nacs.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/choose")
@RequiredArgsConstructor
public class ChooseEndpoint {

    private final CupClient cupClient;

    @GetMapping("/{number}")
    Boolean get(@PathVariable Integer number) {
        return cupClient.get(number);
    }

}
