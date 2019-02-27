package at.nacs.ex5thecalculator.controller;


import at.nacs.ex5thecalculator.controller.operation.Operation;
import at.nacs.ex5thecalculator.model.Expression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class Calculator {


    private final Set<Operation> operations;

    public double calculate(Expression expression) {

        return operations.stream()
                .filter(e -> e.matches(expression))
                .map(e -> e.apply(expression))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
