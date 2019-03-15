package at.nacs.encoder;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/encode")
public class EncoderEndpoint {


    private final EncoderClient encoderClient;


    @PostMapping()
    String post(@RequestBody String message) {
        return encoderClient.translate(message);
    }
}
