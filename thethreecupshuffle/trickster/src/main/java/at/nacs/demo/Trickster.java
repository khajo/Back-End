package at.nacs.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Trickster {

    private final Cups cups;
    private Random random = new Random();


    public String putCoin() {
        int cupNumber = random.nextInt(3)+1;
        String url = cups.getCupList().get(cupNumber);
      //  restTemplate.put(url, Cup.class);
        return url;
    }

    public List<String> delete() {
        return cups.getCupList()
                .values()
                .stream()
                .collect(Collectors.toList());

    }
    public  String choosedUrl(Integer number) {
        return cups.getCupList().get(number);
    }

}
