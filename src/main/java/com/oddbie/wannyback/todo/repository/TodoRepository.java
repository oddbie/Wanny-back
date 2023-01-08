package com.oddbie.wannyback.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.oddbie.wannyback.todo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query("SELECT u FROM Todo u")
    public List<Todo> findAll();
}
