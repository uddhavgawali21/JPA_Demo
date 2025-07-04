package com.ud.JPA_Demo.service;

import com.ud.JPA_Demo.entity.Student;
import com.ud.JPA_Demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public void updateById(Student newstudent,int id){
         studentRepo.findById(id).map(student -> {
             student.setName(newstudent.getName());
             student.setCity(newstudent.getCity());
             student.setAge(newstudent.getAge());

             return studentRepo.save(student);

         });

    }

}
