package at.nacs.demo;


import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;


@Component
public class Runners {

    private List<Runner> runners = new ArrayList<>();

    public void add(Runner runner) {
        runners.add(runner);
    }

    public List<Runner> getAll() {
        return runners;
        // retern new ArrayList(runners)<>;
    }

    public Optional<Runner> getWinner() {
        return runners.stream().min(comparing(Runner::getTime));
    }

}
