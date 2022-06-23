package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.request.CreateStudentRequest;
import com.example.student.request.UpdateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.student.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    // 1. Lay danh sach student
//    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @GetMapping("")
    public List<Student> getAllStudent() {
        return studentService.getStudent();
    }

    //2. tim kiem theo ten
    // http://localhost:8080/users/search?name=An&gender=male (query string) : loc du lieu
//    @RequestMapping(value = "/students/search", method = RequestMethod.GET)
    @GetMapping("/search")
    public List<Student> searchStudent(@RequestParam String name) {
        return studentService.searchStudent(name);
    }
    //3. lay student
    // http://localhost:8080/users/1
//    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

//    4.Xoa
//    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
    //    5.tao sinh vien moi
//    @RequestMapping(value = "/students", method = RequestMethod.POST)
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody CreateStudentRequest request){
        return studentService.createStudent(request);
    }

    //    5.Cap ngat thong tin moi
//    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id,@RequestBody UpdateStudentRequest request ){
        return studentService.updateStudent(id, request);
    }
}
