package com.alibou.demo.subject;

import com.alibou.demo.chapter.Chapter;
import com.alibou.demo.student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Subject {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;

    @OneToMany(mappedBy = "subject")
    private List<Chapter> chapters;
}
