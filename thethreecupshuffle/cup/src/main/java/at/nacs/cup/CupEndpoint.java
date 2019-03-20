package at.nacs.cup;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coin")
@RequiredArgsConstructor
public class CupEndpoint {

    private final Cup cup;

    @GetMapping
    boolean get() {
        return cup.getCoin();
    }

    @PutMapping
    void put() {
        cup.setCoin(true);
    }


    @DeleteMapping
    void delete() {
        cup.setCoin(false);
    }
}
