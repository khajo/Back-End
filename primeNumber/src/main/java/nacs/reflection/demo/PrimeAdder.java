package nacs.reflection.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class PrimeAdder {

    private final Primes primes;


    public Integer counter(Integer number) {
        return IntStream.iterate(0, n -> n + 1)
                .filter(e -> primes.isPrime(e))
                .limit(number)
                .sum();


    }
}
