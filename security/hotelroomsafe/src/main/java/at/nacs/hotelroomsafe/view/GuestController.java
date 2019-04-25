package at.nacs.hotelroomsafe.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/guest")
public class GuestController {

  @GetMapping
  String page() {
    return "guest";
  }

  @ModelAttribute("principal")
  Principal principal(Principal principal) {
    return principal;
  }

}
