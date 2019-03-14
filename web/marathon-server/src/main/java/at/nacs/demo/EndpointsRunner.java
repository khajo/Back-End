package at.nacs.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/runners")
@RequiredArgsConstructor
public class EndpointsRunner {

    private final Runners runners;

    @GetMapping
    List<Runner> getRunners() {
        return runners.getAll();
    }


    @PostMapping
    Runner postRunner(@RequestBody Runner runner) {
        runners.add(runner);
        return runner;
    }

}
