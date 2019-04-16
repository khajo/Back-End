package at.nacs.themagic8ball;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class IndexController {

    private final Magician magician;


    @ModelAttribute("message")
    String message() {
        return magician.getMessageRandomly();
    }

    @GetMapping("/")
    String page() {
        return "ma";
    }


}
