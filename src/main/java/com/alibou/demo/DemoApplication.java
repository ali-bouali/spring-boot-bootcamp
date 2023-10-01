package com.alibou.demo;

import com.alibou.demo.course.Course;
import com.alibou.demo.course.CourseRepository;
import com.alibou.demo.student.Student;
import com.alibou.demo.student.StudentRepo;
import com.alibou.demo.teacher.Teacher;
import com.alibou.demo.teacher.TeacherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			CourseRepository cRepo,
			StudentRepo sRepo
	) {
		return  args -> {
			var course = new Course();
			course.setName("Spring");
			cRepo.save(course);


			var student = new Student();
			student.setFirstname("Chaima");
			student.setCourses(List.of(course));
			sRepo.save(student);


		};
	}
}
