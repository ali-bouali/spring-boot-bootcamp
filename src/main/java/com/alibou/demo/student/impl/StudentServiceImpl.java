package com.alibou.demo.student.impl;

import com.alibou.demo.student.Student;
import com.alibou.demo.student.StudentMapper;
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
    private final StudentMapper mapper;

    @Override
    public void save(StudentRequest s) {
        Student student = mapper.toStudent(s);
        this.studentRepository.save(student);
    }

    @Override
    public StudentResponse findById(Integer id) {
        return this.studentRepository.findById(id)
                .map(mapper::toStudentDto)
                .orElse(new StudentResponse());
    }

    @Override
    public List<StudentResponse> findAll() {
        return this.studentRepository.findAll()
                .stream()
                .map(mapper::toStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        this.studentRepository.deleteById(id);
    }
}
