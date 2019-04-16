package at.nacs.todoui;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.pattern.PathPattern;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoClient {
    private final RestTemplate restTemplate;



    private String url;


    List<ToDo> getAll() {
        ToDo[] todos = restTemplate.getForObject(url, ToDo[].class);
        return Arrays.asList(todos);
    }




}
