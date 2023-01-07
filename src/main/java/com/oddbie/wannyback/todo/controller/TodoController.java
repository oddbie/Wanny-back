package com.oddbie.wannyback.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.oddbie.wannyback.todo.model.Todo;
import com.oddbie.wannyback.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/api/todolist")
    public List<Todo> getTodoList() {
        return todoService.getTodoList();
    }
}
