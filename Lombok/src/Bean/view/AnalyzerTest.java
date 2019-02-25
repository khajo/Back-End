package Bean.view;

import Bean.controller.Statistic;
import org.junit.jupiter.api.Test;

import java.util.List;

class AnalyzerTest {

    @Test
    void display() {
        List<List<String>> lists = Statistic.getAllPercentage();
      Analyzer.display(lists);
    }
}