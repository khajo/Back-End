package at.nacs.administrationui.ui.advice;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@ControllerAdvice(basePackages = "at.nacs.drhouseadministration.ui.controller")
public class UserControllerAdvice {

  @ModelAttribute("user")
  String user(@AuthenticationPrincipal Principal principal) {
    if (isNotLoggedIn(principal)) {
      return null;
    }
    return principal.getName();
  }

  private boolean isNotLoggedIn(Principal principal) {
    return principal == null;
  }
}
