package at.nacs.ex4theenglishgentleman;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Lighter {



    public void lit(Cigar cigar) {
        cigar.setLit(true);
    }











}
