package com.alibou.demo;

import com.alibou.demo.course.Course;
import com.alibou.demo.course.CourseRepository;
import com.alibou.demo.teacher.Teacher;
import com.alibou.demo.teacher.TeacherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			CourseRepository cRepo,
			TeacherRepo tRepo
	) {
		return  args -> {
			var teacher = new Teacher();
			teacher.setFirstname("Ali");
			teacher.setMat("23445");
			tRepo.save(teacher);

			var course = new Course();
			course.setName("Spring boot");
			course.setTeacher(teacher);
			cRepo.save(course);
		};
	}
}
