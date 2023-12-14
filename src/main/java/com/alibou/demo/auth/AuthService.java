package com.alibou.demo.auth;

import com.alibou.demo.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthMapper mapper;
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(AuthRequest request) {
        var student = mapper.toStudent(request);
        var encryptedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(encryptedPassword);
        studentRepository.save(student);
    }
}
