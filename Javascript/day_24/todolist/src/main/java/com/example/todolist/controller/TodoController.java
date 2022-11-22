package com.example.todolist.controller;

import com.example.todolist.entity.Todo;
import com.example.todolist.request.CreateTodoRequest;
import com.example.todolist.request.UpdateTodoRequest;
import com.example.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TodoController {


    @Autowired
    private TodoService todoService;

    //    /todos
//    ../status=true
//    ../status=false
    @GetMapping("/todos")
    public List<Todo> getTodos(@RequestParam(required = false,defaultValue = "") String status) {
        return todoService.getTodos(status);
    }

    // tim theo id
    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable int id){
        return todoService.getTodoById(id);
    }
//    3. Tạo mới todos
    @PostMapping("/todos")
    public Todo createTodo(@RequestBody CreateTodoRequest request){
        return todoService.createTodo(request);
    }
//    4. Cập nhật todos
    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody UpdateTodoRequest request){
        return todoService.updateTodo(id,request);
    }
//    5. Xóa todos
    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable int id){
        todoService.deleteTodo(id);
    }
}
