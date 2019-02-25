package at.nacs.ex4theenglishgentleman;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component

public class Lighter {

    private Cigar cigar;

    public Lighter(Cigar cigar) {
        this.cigar = cigar;
    }






}
