package com.alibou.demo.student.impl;

import com.alibou.demo.student.Student;
import com.alibou.demo.student.StudentRepository;
import com.alibou.demo.student.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(Student s) {
        this.studentRepository.save(s);
    }

    @Override
    public Student findById(Integer id) {
        return this.studentRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        this.studentRepository.deleteById(id);
    }
}
