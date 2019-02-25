package at.nacs.ex4theenglishgentleman;

import org.springframework.stereotype.Component;

@Component
public class Cigar {

    private Boolean lit = false;


    public Boolean isLit() {
        return lit;
    }

    public String smoke() {
        if (isLit()) {
            throw new EmptyStackException();
        }

    }

}
