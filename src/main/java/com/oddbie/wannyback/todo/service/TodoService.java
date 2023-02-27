package com.oddbie.wannyback.todo.service;

import org.springframework.stereotype.Service;

import java.util.List;
import com.oddbie.wannyback.todo.model.Todo;
import com.oddbie.wannyback.todo.repository.TodoRepository;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodo(Long id) {
        return todoRepository.findById(id);
    }

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
