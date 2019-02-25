package Bean.tests;

import Bean.controller.CanFiller;
import Bean.controller.Processor;
import Bean.model.Bean;
import org.junit.jupiter.api.Test;

import java.util.List;

class ProcessorTest {

    @Test
    void getLastBean() {

        List<Bean> beans = CanFiller.fill(10);

        System.out.println(CanFiller.fill(10));
        System.out.println(Processor.getLastBean(beans));
    }
}