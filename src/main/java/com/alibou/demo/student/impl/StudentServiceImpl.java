package com.alibou.demo.student.impl;

import com.alibou.demo.student.Student;
import com.alibou.demo.student.StudentRequest;
import com.alibou.demo.student.StudentResponse;
import com.alibou.demo.student.StudentRepository;
import com.alibou.demo.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void save(StudentRequest s) {
        Student student = toStudent(s);
        this.studentRepository.save(student);
    }

    @Override
    public StudentResponse findById(Integer id) {
        return this.studentRepository.findById(id)
                .map(this::toStudentDto)
                .orElse(new StudentResponse());
    }

    @Override
    public List<StudentResponse> findAll() {
        return this.studentRepository.findAll()
                .stream()
                .map(this::toStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        this.studentRepository.deleteById(id);
    }

    private StudentResponse toStudentDto(Student std) {
        return StudentResponse.builder()
                .firstname(std.getFirstname())
                .lastname(std.getLastname())
                .age(std.getAge())
                .nbrSubjects(std.getSubjects().size())
                .build();
    }

    private Student toStudent(StudentRequest s) {
        Student student = new Student();
        student.setId(s.getId());
        student.setFirstname(s.getFirstname());
        student.setLastname(s.getLastname());
        student.setAge(s.getAge());
        return student;
    }
}
