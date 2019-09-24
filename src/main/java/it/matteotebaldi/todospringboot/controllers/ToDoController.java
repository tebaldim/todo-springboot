package it.matteotebaldi.todospringboot.controllers;

import it.matteotebaldi.todospringboot.beans.ToDo;
import it.matteotebaldi.todospringboot.services.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.*;

@CrossOrigin
@RestController
@RequestMapping("/todo")
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping(value = "/", produces = APPLICATION_JSON_VALUE)
    public List<ToDo> getAllTodo() {
        return toDoService.getAllTodos();
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ToDo getTodo(@PathVariable("id") Long id) {
        return toDoService.getTodo(id);
    }

    @PostMapping(value = "/", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ToDo createTodo(@RequestBody ToDo todo) {
        return toDoService.createTodo(todo);
    }

    @PostMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ToDo updateTodo(@PathVariable("id") Long id, @RequestBody ToDo todo) {
        return toDoService.updateTodo(todo);
    }

    @DeleteMapping(value = "/{id}")
    private void deleteTodo(@PathVariable Long id) {
        toDoService.deleteToDo(id);
    }
}
