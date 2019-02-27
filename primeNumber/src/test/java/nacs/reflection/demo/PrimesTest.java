package nacs.reflection.demo;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PrimesTest {


    @Autowired
    Primes primes;

    @Test
    void testIsPrimeNumber() {
        System.out.println(primes.isPrimeNumber(2));
      //  Assertions.assertTrue( primes.isPrimeNumber(3));

    }
}