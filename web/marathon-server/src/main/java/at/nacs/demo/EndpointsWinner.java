package at.nacs.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/winner")
@RequiredArgsConstructor
public class EndpointsWinner {
    private final Runners runners;


    @GetMapping
    Runner getWinner() {
        return runners.getWinner().orElse(null);
    }
}
