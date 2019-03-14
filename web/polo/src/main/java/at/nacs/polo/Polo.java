package at.nacs.polo;


import org.springframework.stereotype.Service;

@Service
public class Polo {


     String getMessage(String message) {

        if ("Marco".equals(message)) {
            return "Polo";
        }
        return "What?";
    }


}
