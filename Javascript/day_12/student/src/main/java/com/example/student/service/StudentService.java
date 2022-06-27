package com.example.student.service;

import com.example.student.exception.BadRequestException;
import com.example.student.exception.NotFoundException;
import com.example.student.model.Student;

import com.example.student.request.CreateStudentRequest;
import com.example.student.request.UpdateStudentRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class    StudentService {
    // tao danh sach sinh vien de quan ly
    private List<Student> students;

    //Khi class dc khoi tao thi chay method de them sinh vien vao list
    public StudentService() {
        init();
    }
    // them 1 so doi tuong student vao list de quan ly
    public void init(){
        students = new ArrayList<>();
        students.add(new Student(1, "Nguyen van A", "@gmail.com"));
        students.add(new Student(2, "Nguyen van B", "@gmail.com"));
        students.add(new Student(3, "Nguyen van C", "@gmail.com"));
        students.add(new Student(4, "Nguyen van D", "@gmail.com"));

    }

    // Lay danh sach student
    public List<Student> getStudent() {
        return students;
    }

    public List<Student> searchStudent(String name) {
        return students.stream()
                .filter(student -> student.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }


    public Student getStudentById(int id) {
        return findById(id).orElseThrow(()->{
            throw new NotFoundException("Khong tim thay id"+ id);
        });
    }

    public void deleteStudent(int id) {
        // B1 : Kiểm tra xem student có tồn tại hay không
        if(findById(id).isEmpty()) {
            throw new NotFoundException("Không tìm thấy sinh viên có id = " + id);
        }

        // B2 : Xóa user
        students.removeIf(student -> student.getId() == id);
    }

    public Student createStudent(CreateStudentRequest request) {
        //B1: Kiem tra email da ton tai hay chua
        if (findByEmail(request.getEmail()).isPresent()){
            throw new BadRequestException("email= "+ request.getEmail()+" da ton tai");
        }
        //B2: Tạo moi
        Random rd = new Random();
        Student student = new Student(rd.nextInt(100), request.getName(), request.getEmail());
        students.add(student);
        return student;
    }

    public Student updateStudent(int id, UpdateStudentRequest request) {
        for (Student student: students) {
            if (student.getId()== id) {
                student.setName(request.getName());
                return student;
            }
        }
        return null;
    }

    // helper method
    public Optional<Student> findById(int id){
        return   students
                .stream()
                .filter(student -> student.getId()==id)
                .findFirst();
    }

    public Optional<Student> findByEmail(String email) {
        return students
                .stream()
                .filter(student -> student.getEmail().equals(email))
                .findFirst();
    }

}
