package com.ud.JPA_Demo.service;

import com.ud.JPA_Demo.entity.Student;
import com.ud.JPA_Demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public Student addStudent(Student student){
        return studentRepo.save(student);
    }
    public List<Student> getStudentData(){
        return studentRepo.findAll();
    }
    public Optional<Student> getStudent(int id){
         return studentRepo.findById(id);
    }
    public void deleteById(int id){
        studentRepo.deleteById(id);

    }
    @Transactional
    public String updateById(Student newstudent,int id){
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            Student dbstud = student.get();
            dbstud.setName(newstudent.getName());
            dbstud.setCity(newstudent.getCity());
            dbstud.setAge(newstudent.getAge());
            studentRepo.save(dbstud);
            return "Student data updated";
        }
        else return "Student not found";

    }
    public String partialUpdate(Map<String,Object> newstudent, int id){
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            Student dbstud = student.get();
            if (newstudent.containsKey("name")){
                dbstud.setName(newstudent.get("name").toString());
            }
            if (newstudent.containsKey("city")){
                dbstud.setCity(newstudent.get("city").toString());
            }
            if (newstudent.containsKey("age")){
                dbstud.setAge((Integer) newstudent.get("age"));
            }
            studentRepo.save(dbstud);
            return "Data updated";
        }
        else {
            return "Student not found";
        }
    }

}
