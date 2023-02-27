package com.oddbie.wannyback;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.oddbie.wannyback.todo.model.Todo;
import com.oddbie.wannyback.todo.repository.TodoRepository;

// @DataJpaTest
// @TestMethodOrder(MethodOrderer.MethodName.class)
// @TestMethodOrder(MethodOrderer.Alphanumeric.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// @TestMethodOrder(MethodOrderer.Random.class)
// @SpringBootTest
class TodoRepositoryTest {
    // @Autowired
    // TodoRepository repository;

    @Test
    @Order(1)
    void contextLoads() {
    }

    // @Test
    // @Transactional
    // @Rollback(false)
    // public void testMember() {
    // Todo todo = new Todo(null, "item6", "testcate", null, null);
    // repository.save(todo);
    // }
}
