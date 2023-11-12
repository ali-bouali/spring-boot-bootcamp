package com.alibou.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/students")
@RestController
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public Student findById(Integer id) {
        Student student = service.findById(9999);
        return student;
    }

    // @RequestMapping(method = RequestMethod.GET, value = "/post")
    // @RequestMapping(method = RequestMethod.GET, value = "/delete")

}
