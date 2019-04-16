package at.nacs.todoui;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class TodoController {

    private final TodoClient client;


    @ModelAttribute("todos")
    List<ToDo> todos() {
        return todos;
    }

    @ModelAttribute("todo")
    ToDo todo() {
        return new ToDo();
    }

    @GetMapping
    String page() {
        return "todos";
    }

    @PostMapping
    String post(@Valid ToDo todo, BindingResult result) {
        if (result.hasErrors()) {
            return page();
        }
        todos.add(todo);
        return "redirect:/cities";
    }

    @PostMapping("/delete")
    String delete(@RequestParam String id) {
        todos.removeIf(todo -> todo.getId().equals(id));
        return "redirect:/todos";
    }

}
