package at.nacs.mypersonaltodo;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ToDoEndpoint {

    private final TODoManager manager;


    @GetMapping("/todos")
    List<ToDo> getAll() {
        return manager.getAll();
    }

    @GetMapping("/todos/{id}")
    ToDo getbyId(@PathVariable String id) {
        return manager.getToDoById(id);
    }

    @PostMapping("/todos")
    ToDo post(@RequestBody ToDo toDo) {
        return manager.add(toDo);
    }

    @PutMapping("/todos/{id}/done")
    ToDo update(@PathVariable String id) {
        return manager.update(id);
    }


    @DeleteMapping("/todos/{id}")
    void delete(@PathVariable String id) {
        manager.delete(id);
    }
}
