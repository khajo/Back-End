package nacs.reflection.demo;


import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class Primes {


    public boolean isPrime(Integer numebr) {
        if (numebr < 2) {
            return false;
        }

        return IntStream.rangeClosed(2, numebr / 2)
                .noneMatch(e -> numebr % e == 0);
    }


}


