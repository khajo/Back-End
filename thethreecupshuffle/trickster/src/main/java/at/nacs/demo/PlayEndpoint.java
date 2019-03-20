package at.nacs.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/play")
@RequiredArgsConstructor
public class PlayEndpoint {
    private final CupClient cupClient;


    @GetMapping
    String get() {
        return cupClient.getToPlay();
    }





}
