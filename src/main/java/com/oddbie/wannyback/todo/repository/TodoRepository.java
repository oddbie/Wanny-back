package com.oddbie.wannyback.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import com.oddbie.wannyback.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query("SELECT u FROM Todo u")
    public List<Todo> findAll();
}
