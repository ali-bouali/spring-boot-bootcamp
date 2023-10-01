package com.alibou.demo.teacher;

import com.alibou.demo.course.Course;
import com.alibou.demo.user.Users;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@DiscriminatorValue("TEACHER")
public class Teacher extends Users {

    private String mat;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;
}
