package com.alibou.demo.student;

import java.util.List;

public interface StudentService {

    void save(Student s);
    Student findById(Integer id);
    List<Student> findAll();
    void deleteById(Integer id);
}
