package Bean.controller;

import lombok.experimental.UtilityClass;
import Bean.model.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@UtilityClass
public class Statistic {

    public List<List<String>> getAllPercentage() {

        return IntStream.range(0,5).mapToObj(e -> getStatisticForOne()).collect(Collectors.toList());
    }


    public List<String> getStatisticForOne() {
        List<Bean> beans = CanFiller.fill(2);
        List<String> list = new ArrayList<>();

            list.add(getBlackBeansPercentage(beans).toString());
            list.add(getWhiteBeansPercentage(beans).toString());
            list.add(Processor.getLastBean(beans).getColor());

        //"Black beans: "+getBlackBeansPercentage(beans) +"%"+ "  " + "White beans: "+getWhiteBeansPercentage(beans) + "  -> get last bean: " + Processor.getLastBean(beans).getColor();
        return list;
    }




    public Double getWhiteBeansPercentage(List<Bean> beans) {
        return (Double.valueOf((Processor.getWhiteBeans(beans).size() * 100)) / beans.size());
    }

    public Double getBlackBeansPercentage(List<Bean> beans) {
        return (Double.valueOf((Processor.getBlackBeans(beans).size() * 100)) / beans.size());
    }

}
