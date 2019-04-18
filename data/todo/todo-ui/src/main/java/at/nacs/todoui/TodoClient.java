package at.nacs.todoui;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoClient {
    private final RestTemplate restTemplate;
    private final String url = "http://localhost:9000/todos";

    public List<ToDo> getAll() {
        return Arrays.asList(restTemplate.getForObject(url, ToDo[].class));
    }

    public ToDo save(ToDo todo) {
        return restTemplate.postForObject(url, todo, ToDo.class);

    }

    public void markAsDone(String id) {
        restTemplate.put(url + "/" + id + "/done", ToDo.class);
    }

    }
