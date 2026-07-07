package com.training.review8.service;

import com.training.review8.model.Student;
import com.training.review8.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    private StudentRepository repo;

    public Student createStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student student) {
        Student existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(student.getName());
            existing.setMarks(student.getMarks());
            return repo.save(existing);
        }

        return null;
    }

    public String deleteStudent(Long id) {
        repo.deleteById(id);
        return "Student deleted successfully";
    }
}