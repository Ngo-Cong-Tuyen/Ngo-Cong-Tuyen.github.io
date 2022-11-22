package com.example.todolist.service;

import com.example.todolist.exception.BadRequestException;
import com.example.todolist.exception.NotFoundException;
import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import com.example.todolist.request.CreateTodoRequest;
import com.example.todolist.request.UpdateTodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodos(String status) {
        return switch (status) {
            case "" -> todoRepository.findAll() ;
            case "true" -> todoRepository.getTodoByStatus(true);
            case "false" -> todoRepository.getTodoByStatus(false);
            default -> throw new BadRequestException("Trang thai ko hhop le");
        };
    }
    public Todo getTodoById(int id) {
        return todoRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Khong tim thay to do co id = "+id);
        });
    }

    public Todo createTodo(CreateTodoRequest request) {
        Random rd = new Random();
        Todo todo = new Todo(rd.nextInt(100), request.getTitle(),false);
        todoRepository.save(todo);
        return todo;
    }

    public Todo updateTodo(int id, UpdateTodoRequest request) {
        Todo todo = todoRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Khong tim thay to do co id = "+id);
        });
        todo.setTitle(request.getTitle());
        todo.setStatus(request.isStatus());
        todoRepository.save(todo);
        return todo;
    }

    public void deleteTodo(int id) {
        if (todoRepository.findById(id).isEmpty()){
            throw new NotFoundException("Khong tim thay todo co id ="+id);
        }
        todoRepository.deleteById(id);
    }
}
