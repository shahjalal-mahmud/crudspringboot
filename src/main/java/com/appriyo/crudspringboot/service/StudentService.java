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

    private Student creatStudent(Student student){
        return studentRepository.save(student);
    }

    private Optional<Student> getStudent(Long id){
        return studentRepository.findById(id);
    }

    private List<Student> getALlStudent(){
        return studentRepository.findAll();
    }

    private void DeleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    private boolean isExist(Long id){
        return studentRepository.existsById(id);
    }
}
