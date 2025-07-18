package com.ud.JPA_Demo.controller;

import com.ud.JPA_Demo.entity.Student;
import com.ud.JPA_Demo.service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class Controller {

    @Autowired
    private StudentService service;

    @PostMapping("/add")
    public String CreateStudent(@RequestBody Student student){
        service.addStudent(student);
        return "Student added";
    }

    @GetMapping("/getData")
    public List<Student> getAllData(){
        return service.getStudentData();
    }

    @GetMapping("/getStudent/{id}")
    public Optional<Student> getStudentById( @PathVariable int id){
        return service.getStudent(id);

    }
    @DeleteMapping("/deleteStudent_id:{id}")
    public String deleteStudentById(@PathVariable int id){
        service.deleteById(id);
        return "Student with id "+id+" is deleted";
    }
    @PutMapping("/updateStudent")
    public String updateById(@RequestBody Student student, @RequestParam int id){
        return service.updateById(student,id);
    }
    @PatchMapping("/Partial")
    public String partialUpdate(@RequestBody Map<String,Object> student,@RequestParam int id){
        return service.partialUpdate(student,id);
    }

}
