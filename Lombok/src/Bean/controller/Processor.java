package Bean.controller;

import lombok.experimental.UtilityClass;
import Bean.model.Bean;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class Processor {

    public Bean getLastBean(List<Bean> beans) {
        List<Bean> beanQ = new LinkedList<>(beans);

        Queue<Bean> beanQueue = (Queue<Bean>) beanQ;


        IntStream.generate(() -> 0)
                .takeWhile(n -> beanQueue.size() > 1)
                .forEach(e -> filter(beanQueue));
        return beanQueue.poll();

    }


    public void filter(Queue<Bean> beans) {
        Bean one = beans.poll();
        Bean two = beans.poll();
        if (one.equals(two)) {
            beans.add(Bean.builder().color("black").build());

        } else {
            beans.add(Bean.builder().color("white").build());
        }

    }
    public List<Bean> getWhiteBeans(List<Bean> beans) {
        return beans.stream().filter(e -> e.getColor().equals("white")).collect(Collectors.toList());
    }
    public List<Bean> getBlackBeans(List<Bean> beans) {
        return beans.stream().filter(e -> e.getColor().equals("black")).collect(Collectors.toList());
    }
}
