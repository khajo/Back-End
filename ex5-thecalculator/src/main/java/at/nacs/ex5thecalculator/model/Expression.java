package at.nacs.ex5thecalculator.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Builder
@Data
public class Expression {
    private String symbol;
    private double number1;
    private double number2;
}
