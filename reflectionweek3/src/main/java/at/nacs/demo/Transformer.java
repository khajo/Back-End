package at.nacs.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class Transformer {

    private final Map<Integer, String> moves;
    private final Converter converter;

    private Scanner scanner = new Scanner(System.in);

    public List<String> gethandShakes() {
        System.out.println("Enter the number");
        Integer digit = scanner.nextInt();
        List<Integer> digits = converter.getDigit(digit);
     return    digits.stream().filter(e -> moves.containsKey(e)).map(e -> moves.get(e)).collect(Collectors.toList());
    }


}
