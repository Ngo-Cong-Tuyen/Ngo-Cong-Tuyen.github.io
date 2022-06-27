package com.example.todolist.service;

import com.example.todolist.exception.BadRequestException;
import com.example.todolist.exception.NotFoundException;
import com.example.todolist.model.Todo;
import com.example.todolist.request.CreateTodoRequest;
import com.example.todolist.request.UpdateTodoRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private List<Todo> todos;
    private TodoService(){
        Random rd = new Random();
        todos = new ArrayList<>();
        todos.add(new Todo(rd.nextInt(100),"di choi",true));
        todos.add(new Todo(rd.nextInt(100),"lam bai",false));
        todos.add(new Todo(rd.nextInt(100),"di nhau",true));
    }

    public List<Todo> getTodos(String status) {
        return switch (status) {
            case "" -> todos;
            case "true" -> todos.stream().filter(Todo::isStatus).collect(Collectors.toList());
            case "false" -> todos.stream().filter(todo -> !todo.isStatus()).collect(Collectors.toList());
            default -> throw new BadRequestException("Trang thai ko hhop le");
        };
    }
    public Todo getTodoById(int id) {
        return findTodoById(id).orElseThrow(()->{
            throw new NotFoundException("Khong tim thay to do co id = "+id);
        });
    }

    public Optional<Todo> findTodoById(int id) {
        return todos.stream()
                .filter(todo -> todo.getId()==id)
                .findFirst();
    }


    public Todo createTodo(CreateTodoRequest request) {
        Random rd = new Random();
        Todo todo = new Todo(rd.nextInt(100), request.getTitle(),false);
        todos.add(todo);
        return todo;
    }

    public Todo updateTodo(int id, UpdateTodoRequest request) {
        if (findTodoById(id).isEmpty()){
            throw new BadRequestException("Khong tim thay todo co id ="+id);
        }
        for (Todo todo: todos){
            if (todo.getId()==id){
                todo.setTitle(request.getTitle());
                todo.setStatus(request.isStatus());
                return todo;
            }
        }
        return null;
    }

    public void deleteTodo(int id) {
        if (findTodoById(id).isEmpty()){
            throw new BadRequestException("Khong tim thay todo co id ="+id);
        }
        todos.removeIf(todo -> todo.getId()==id);
    }
}
