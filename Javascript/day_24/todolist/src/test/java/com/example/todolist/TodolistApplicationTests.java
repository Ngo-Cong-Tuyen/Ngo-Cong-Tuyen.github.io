package com.example.todolist;

import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class TodolistApplicationTests {


    @Autowired
    private TodoRepository todoRepository;

    @Test
    void saveTodo() {
        Todo todo1 = Todo.builder()
                .title("Di choi voi ban")
                .status(true)
                .build();

        Todo todo2 = Todo.builder()
                .title("Di dam cuoi")
                .status(true)
                .build();

        Todo todo3 = Todo.builder()
                .title("Di da bong")
                .status(true)
                .build();

        Todo todo4 = Todo.builder()
                .title("Di cho")
                .status(true)
                .build();

        todoRepository.saveAll(Arrays.asList(todo1,todo2,todo3,todo4));
    }

}
