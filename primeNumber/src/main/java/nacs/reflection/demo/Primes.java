package nacs.reflection.demo;


import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class Primes {


    public Integer isPrimeNumber(Integer number) {
        return IntStream.of(number)
                .dropWhile(e -> e < 2)
               // .map(e -> Integer.valueOf(e / 2))
                .filter(e -> e > 2)
                .peek(e -> System.out.println("the Number " + e))
                .map(e->number%e)
                .findFirst().getAsInt();
               // .anyMatch(e -> number % e == 1);
    }

    public Integer filter(Integer number) {
        if (number < 2) {
            number = 2;
        }



        return null;
    }

}
