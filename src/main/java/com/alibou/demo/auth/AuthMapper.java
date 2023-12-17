package com.alibou.demo.auth;

import com.alibou.demo.student.Student;
import org.springframework.stereotype.Service;

@Service
public class AuthMapper {

    public Student toStudent(RegisterRequest s) {
        Student student = new Student();
        student.setFirstname(s.getFirstname());
        student.setLastname(s.getLastname());
        student.setEmail(s.getEmail());
        // FIXME
        student.setPassword(s.getPassword());
        student.setEnabled(true);
        return student;
    }
}
