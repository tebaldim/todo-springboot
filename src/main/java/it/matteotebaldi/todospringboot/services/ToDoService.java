package it.matteotebaldi.todospringboot.services;

import it.matteotebaldi.todospringboot.beans.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getAllTodos();
    ToDo getTodo(Long id);
    ToDo createTodo(ToDo todo);
    ToDo updateTodo(ToDo todo);
    void deleteToDo(Long id);
}
