package it.matteotebaldi.todospringboot.services.impl;

import it.matteotebaldi.todospringboot.beans.ToDo;
import it.matteotebaldi.todospringboot.services.ToDoService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Scope("singleton")
public class ToDoServiceImpl implements ToDoService {

    private Map<Long, ToDo> archive = new HashMap<>();
    private Long maxId = 0L;

    @Override
    public List<ToDo> getAllTodos() {
        List<ToDo> result = new LinkedList<>();
        archive.forEach((Long id, ToDo todo) -> {
            result.add(todo);
        });
        return result;
    }

    @Override
    public ToDo getTodo(Long id) {
        Optional<ToDo> first = archive.entrySet().stream()
                .filter(x -> id.equals(x.getKey()))
                .map(Map.Entry::getValue)
                .findFirst();
        ToDo result = null;
        if(first.isPresent())
            result = first.get();
        return result;
    }

    @Override
    public ToDo createTodo(ToDo todo) {
        todo.setId(maxId++);
        archive.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public ToDo updateTodo(ToDo todo) {
        ToDo result = null;
        if (archive.containsKey(todo.getId())) {
            archive.replace(todo.getId(), todo);
            result = todo;
        }
        return result;
    }

    @Override
    public void deleteToDo(Long id) {
        archive.remove(id);
    }
}
