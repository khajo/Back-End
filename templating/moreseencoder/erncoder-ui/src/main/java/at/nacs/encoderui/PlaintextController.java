package at.nacs.encoderui;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class PlaintextController {
    private Plaintext plaintext = new Plaintext();
    private final EncoderClient encoderClient;

    @ModelAttribute("plaintext")
    Plaintext plaintext() {
        return plaintext;
    }

    @GetMapping
    String page() {
        return "plaintext-form";
    }


    @PostMapping
    String post(@Valid Plaintext plaintext, BindingResult result, RedirectAttributesModelMap redirect) {
        if (result.hasErrors()) {
            return page();
        }
        this.plaintext=plaintext;
        redirect.addFlashAttribute("encoded",encoderClient.sendToEncoder(plaintext.getText()));
        return "redirect:/";
    }


}


//    @ModelAttribute("message")
//    Message message() {
//        return message;
//    }
//
//    @GetMapping
//    String page() {
//        return "messages/form-message";
//    }
//
//    @PostMapping
//    String post(Message message, BindingResult result) {
//        if (result.hasErrors()) {
//            return page();
//        }
//        this.message = message;
//        return "redirect:/message/form";
//    }
