package fruit.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitCounterTest {

    @Test
    void display() {
        FruitCounter.display("fruit/testFile.txt");
    }
}