package at.nacs.thethievesden.communication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/alibaba")
public class UserEndpoint {

  @GetMapping
  @RolesAllowed("ALIBABA")
  List<String> treasures() {
    return Arrays.asList("Gold","Money","silver","Bier","Vodka");
  }

}
