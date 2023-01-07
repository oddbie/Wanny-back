package com.oddbie.wannyback.todo.service;

import org.springframework.stereotype.Service;

import java.util.List;
import com.oddbie.wannyback.todo.model.Todo;
import com.oddbie.wannyback.todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }
}
