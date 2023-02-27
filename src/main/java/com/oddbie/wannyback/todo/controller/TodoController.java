package com.oddbie.wannyback.todo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import com.oddbie.wannyback.todo.model.Todo;
import com.oddbie.wannyback.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/todolist")
    public List<Todo> getTodoList() {
        return todoService.getTodoList();
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> createTodoItem(@RequestBody Todo todo) throws URISyntaxException {
        Todo savedTodo = todoService.saveTodo(todo);
        return ResponseEntity.created(new URI("/todo/" + savedTodo.getId())).body(savedTodo);
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<Todo> updateTodoItem(@PathVariable Long id, @RequestBody Todo todo) throws RuntimeException {
        Todo curTodo = todoService.getTodo(id).orElseThrow(RuntimeException::new);
        curTodo.setItem(todo.getItem());
        curTodo.setCategory(todo.getCategory());
        curTodo.setDueDate(todo.getDueDate());
        curTodo.setFinishDate(todo.getFinishDate());
        curTodo = todoService.saveTodo(curTodo);
        return ResponseEntity.ok(curTodo);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<Todo> deleteTodoItem(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }
}
