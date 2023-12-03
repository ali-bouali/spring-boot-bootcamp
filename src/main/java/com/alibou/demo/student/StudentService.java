package com.alibou.demo.student;

import java.util.List;

public interface StudentService {

    Integer save(StudentRequest s);
    StudentResponse findById(Integer id);
    List<StudentResponse> findAll();
    void deleteById(Integer id);
}
