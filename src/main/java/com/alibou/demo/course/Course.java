package com.alibou.demo.course;

import com.alibou.demo.base.BaseClass;
import com.alibou.demo.student.Student;
import com.alibou.demo.teacher.Teacher;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course extends BaseClass {

    private String name;

    @ManyToOne
    @JoinColumn(name = "t_id")
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
