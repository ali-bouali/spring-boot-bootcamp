package com.alibou.demo;

import com.alibou.demo.book.Book;
import com.alibou.demo.book.BookId;
import com.alibou.demo.book.BookRepository;
import com.alibou.demo.student.Student;
import com.alibou.demo.student.StudentRepo;
import com.alibou.demo.teacher.TeacherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			StudentRepo repo,
			TeacherRepo trepo,
			BookRepository brepo
	) {
		return  args -> {
			// repo.save(new Student("Alibou ", "Alibou"));
			// repo.save(new Student("Alibou ", "Alibou"));
			// repo.save(new Student("Alibou ", "Alibou"));
			// repo.save(new Student("adasd", "Alibou", "mail@mail.com"));
			// repo.save(new Student("asddddd", "dddddd", "mail@mail.com"));
//			var s = new Student();
//			s.setFirstname("Ali");
//			s.setNce("12313");
//			repo.save(s);
//
//			var s2 = new Student();
//			s2.setFirstname("Ali 2");
//			s2.setNce("22222");
//			repo.save(s2);
//
//
//			repo.findAll()
//					.forEach(System.out::println);

//			var t = new Teacher();
//			t.setFirstname("Ali");
//			trepo.save(t);

			var id = new BookId("Ali", LocalDate.now());
			var book = new Book(id, 300);
			brepo.save(book);

			var id2 = new BookId("Ali", LocalDate.now());
			var book2 = new Book(id2, 400);
			brepo.save(book2);
		};
	}
}
