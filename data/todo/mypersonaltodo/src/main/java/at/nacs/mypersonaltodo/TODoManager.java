package at.nacs.mypersonaltodo;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TODoManager {

    private final ToDoRepository repository;


    public List<ToDo> getAll() {
        return repository.findAll();
    }

    public ToDo getToDoById(String id) {
        return repository.findById(id).get();
    }


    public ToDo add(ToDo toDo) {
        return repository.save(toDo);
    }

    public ToDo update(String id) {
        ToDo toDoById = getToDoById(id);
        toDoById.setDone(true);
        repository.save(toDoById);
        return toDoById;
    }

    public void delete(String id) {
        repository.deleteById(id);
    }


}

//    Optional<Item> findOneByName(String name);
//
//    List<Item> findByType(String electronics);
//
//    List<Item> findByNameAndPrice(String sofa, double price);
//
//    List<Item> findByPriceLessThan(double price);
//
//    List<Item> findByPriceBetween(double price1, double price2);
//
//    List<Item> findByOrderByPriceAsc();