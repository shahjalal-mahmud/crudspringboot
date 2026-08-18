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

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public boolean isExist(Long id) {
        return !studentRepository.existsById(id);
    }

    public Student updateStudent(Long id, Student studentDetails){
        return studentRepository.findById(id)
                .map(existingStudent -> {
                    existingStudent.setName(studentDetails.getName());
                    existingStudent.setAge(studentDetails.getAge());
                    existingStudent.setRollNumber(studentDetails.getRollNumber());
                    existingStudent.setSubject(studentDetails.getSubject());
                    return studentRepository.save(existingStudent);
                })
                .orElseThrow( () -> new RuntimeException("Student not found with the id: " + id));
    }
}