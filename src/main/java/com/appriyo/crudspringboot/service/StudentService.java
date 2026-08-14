package com.appriyo.crudspringboot.service;

import com.appriyo.crudspringboot.entity.Student;
import com.appriyo.crudspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // Create a Student
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    // Get a Student
    public Optional<Student> getStudent(Long id){
        return studentRepository.findById(id);
    }

    // Get all Students
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
