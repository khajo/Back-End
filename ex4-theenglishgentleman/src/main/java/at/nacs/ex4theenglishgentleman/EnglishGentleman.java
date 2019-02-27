package at.nacs.ex4theenglishgentleman;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
@RequiredArgsConstructor
public class EnglishGentleman {
    private final Monocle monocle;
    private final Lighter lighter;
    @Getter
    private boolean hasRead;
    @Getter
    private boolean hasSmoked;


    public void smoke(Cigar cigar) throws CigarWasNotLitException {
        lighter.lit(cigar);
        cigar.smoke();
        hasSmoked = true;
    }



    public void read(Newspaper newspaper) {
        monocle.read(newspaper);
        hasRead = true;
    }

    public boolean hadAGoodDay() {

        return hasRead && hasSmoked;
    }
}
