package com.alibou.demo.student;

import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public StudentResponse toStudentDto(Student std) {
        return StudentResponse.builder()
                .firstname(std.getFirstname())
                .lastname(std.getLastname())
                .age(std.getAge())
                .nbrSubjects(std.getSubjects().size())
                .build();
    }

    public Student toStudent(StudentRequest s) {
        Student student = new Student();
        student.setId(s.getId());
        student.setFirstname(s.getFirstname());
        student.setLastname(s.getLastname());
        student.setAge(s.getAge());
        return student;
    }
}
