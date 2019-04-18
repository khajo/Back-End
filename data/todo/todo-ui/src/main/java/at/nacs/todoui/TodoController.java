package at.nacs.todoui;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/")
@Controller
public class TodoController {

    private final TodoClient client;

    @ModelAttribute("todos")
    List<ToDo> todos() {
        return client.getAll();
    }

    @ModelAttribute("todo")
    ToDo todo() {
        return new ToDo();
    }

    @GetMapping
    String page() {
        return "my-personal-todo-list-ui";
    }

    @PostMapping
    String post(@Valid ToDo todo, BindingResult result) {
        if (result.hasErrors()) {
            return page();
        }
        client.save(todo);
        return "redirect:/";
    }

    @PostMapping("/done")
    String put(@RequestParam String id) {
        client.markAsDone(id);
        return "redirect:/";
    }

}
