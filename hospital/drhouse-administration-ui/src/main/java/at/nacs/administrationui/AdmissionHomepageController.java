package at.nacs.administrationui;


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
@RequiredArgsConstructor
@RequestMapping("/")
public class AdmissionHomepageController {

    private final AdmissionClient admissionClient;


    @ModelAttribute("patient")
    Patient patient() {
        return new Patient();
    }

    @GetMapping
    String page() {
        return "admission-homepage";
    }


    @PostMapping
    String post(@Valid Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return page();
        }
        admissionClient.send(patient);
        return "redirect:/";
    }

}
