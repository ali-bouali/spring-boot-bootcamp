package com.alibou.demo.auth;

import com.alibou.demo.config.JwtService;
import com.alibou.demo.student.StudentRepository;
import com.alibou.demo.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthMapper mapper;
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    public void register(RegisterRequest request) {
        var student = mapper.toStudent(request);
        var encryptedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(encryptedPassword);
        studentRepository.save(student);
    }

    public AuthResponse authenticate(AuthRequest request) {
        Authentication authenticatedUser = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var userDetails = (User) authenticatedUser.getPrincipal();
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("firstname", userDetails.getFirstname());
        var jwtToken = jwtService.generateToken(claims, userDetails);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
