package Bean.tests;

import Bean.controller.CanFiller;
import Bean.model.Bean;
import org.junit.jupiter.api.Test;

import java.util.List;



class CanFillerTest {
@Test
    void fill() {

    List<Bean> beans= CanFiller.fill(10);
    System.out.println(beans);
    }
}